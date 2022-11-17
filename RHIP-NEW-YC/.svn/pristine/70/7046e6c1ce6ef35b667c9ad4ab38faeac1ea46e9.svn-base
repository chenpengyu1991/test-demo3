/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;

import com.founder.fasf.exception.SerializationException;

/**
 * <p>
 * Assists with the serialization process and performs additional functionality
 * based on serialization.
 * </p>
 * <p>
 * <ul>
 * <li>Deep clone using serialization
 * <li>Serialize managing finally and IOException
 * <li>Deserialize managing finally and IOException
 * </ul>
 * 
 * <p>
 * This class throws exceptions for invalid <code>null</code> inputs. Each
 * method documents its behaviour in more detail.
 * </p>
 */
public final class SerializationUtil extends BaseUtil {

	/**
	 * By default, to resolve the classes being deserialized JDK serialization
	 * uses the classes loader which loaded the class which initiated the
	 * deserialization call. Here that would be hibernate classes. However,
	 * there are cases where that is not the correct class loader to use; mainly
	 * here we are worried about deserializing user classes in environments (app
	 * servers, etc) where Hibernate is on a parent classes loader. To
	 * facilitate for that we allow passing in the class loader we should use.
	 */
	private static final class CustomObjectInputStream extends ObjectInputStream {

		private final ClassLoader loader1;

		private final ClassLoader loader2;

		private final ClassLoader loader3;

		private CustomObjectInputStream(InputStream in, ClassLoader loader1, ClassLoader loader2, ClassLoader loader3) throws IOException {
			super(in);
			this.loader1 = loader1;
			this.loader2 = loader2;
			this.loader3 = loader3;
		}

		private boolean different(ClassLoader one, ClassLoader other) {
			if (one == null) {
				return other != null;
			}
			return !one.equals(other);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected Class<?> resolveClass(ObjectStreamClass v) throws IOException, ClassNotFoundException {
			final String className = v.getName();
			log.trace("Attempting to locate class [" + className + "]");
			try {
				return Class.forName(className, false, loader1);
			} catch (ClassNotFoundException e) {
				log.trace("Unable to locate class using given classloader");
			}
			if (different(loader1, loader2)) {
				try {
					return Class.forName(className, false, loader2);
				} catch (ClassNotFoundException e) {
					log.trace("Unable to locate class using given classloader");
				}
			}
			if (different(loader1, loader3) && different(loader2, loader3)) {
				try {
					return Class.forName(className, false, loader3);
				} catch (ClassNotFoundException e) {
					log.trace("Unable to locate class using given classloader");
				}
			}
			// By default delegate to normal JDK deserialization which will use
			// the class loader
			// of the class which is calling this deserialization.
			return super.resolveClass(v);
		}
	}

	private SerializationUtil() {
	}

	private static InputStream wrap(byte[] objectData) {
		if (objectData == null) {
			throw new IllegalArgumentException("The byte[] must not be null");
		}
		return new ByteArrayInputStream(objectData);
	}

	// Serialize
	// -----------------------------------------------------------------------
	/**
	 * Serialize the given object to a byte array.
	 * 
	 * @param object
	 *            the object to serialize
	 * @return an array of bytes representing the object in a portable fashion
	 */
	public static byte[] serialize(Object object) {
		if (object == null) {
			return null;
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			oos.flush();
		} catch (IOException ex) {
			throw new IllegalArgumentException("Failed to serialize object of type: " + object.getClass(), ex);
		}
		return baos.toByteArray();
	}

	/**
	 * 
	 * Serializes an <code>Object</code> to a byte array for
	 * storage/serialization.
	 * 
	 * @param obj
	 *            the object to serialize to bytes
	 * 
	 * @return a byte[] with the converted Serializable
	 * 
	 * @throws SerializationException
	 *             (runtime) if the serialization fails
	 */
	public static byte[] serialize(Serializable obj) throws SerializationException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
		serialize(obj, byteArrayOutputStream);
		return byteArrayOutputStream.toByteArray();
	}

	public static void serialize(String configDirectory, String fileName, Object o) {
		String fullFilename = configDirectory + "/" + fileName;
		log.debug("Attempting to serialize object into file: " + fullFilename);
		try {
			ObjectOutputStream ois = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fullFilename)));
			ois.writeObject(o);
			ois.flush();
			ois.close();
		} catch (Exception e) {
			log.error("Failed while serializing object (into the file" + fullFilename + " ): " + e.getMessage(), e);
			throw new RuntimeException("Failed while serializing object (into the file" + fullFilename + " ): " + e.getMessage());
		}
	}

	/**
	 * Serializes an <code>Object</code> to the specified stream. The stream
	 * will be closed once the object is written. This avoids the need for a
	 * finally clause, and maybe also exception handling, in the application
	 * code. The stream passed in is not buffered internally within this method.
	 * This is the responsibility of your application if desired.
	 * 
	 * @param obj
	 *            the object to serialize to bytes, may be null
	 * @param outputStream
	 *            the stream to write to, must not be null
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>outputStream</code> is <code>null</code>
	 * @throws SerializationException
	 *             (runtime) if the serialization fails
	 */
	public static void serialize(Serializable obj, OutputStream outputStream) throws SerializationException {
		if (outputStream == null) {
			throw new IllegalArgumentException("The OutputStream must not be null");
		}
		if (log.isTraceEnabled()) {
			/*
			 * if ( Hibernate.isInitialized( obj ) ) { LOG.tracev(
			 * "Starting serialization of object [{0}]", obj ); } else {
			 */
			log.trace("Starting serialization of [uninitialized proxy]");
			// }
		}
		ObjectOutputStream out = null;
		try {
			// stream closed in the finally
			out = new ObjectOutputStream(outputStream);
			out.writeObject(obj);
		} catch (IOException ex) {
			throw new SerializationException("could not serialize", ex);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (IOException ignored) {
			}
		}
	}

	// Deserializes
	// --------------------------------------------------------------------
	/**
	 * Deserializes an object from an array of bytes using the Thread Context
	 * ClassLoader (TCCL). If there is no TCCL set, the classloader of the
	 * calling class is used. Delegates to
	 * {@link #deserialize(byte[], ClassLoader)}
	 * 
	 * @param objectData
	 *            the serialized object, must not be null
	 * @return the deserialized object
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>objectData</code> is <code>null</code>
	 * @throws SerializationException
	 *             (runtime) if the serialization fails
	 */
	public static Object deserialize(byte[] objectData) throws SerializationException {
		return doDeserialize(wrap(objectData), Thread.currentThread().getContextClassLoader(), SerializationUtil.class.getClassLoader(), null);
	}

	/**
	 * Deserializes an object from an array of bytes.
	 * <p/>
	 * Delegates to {@link #deserialize(java.io.InputStream, ClassLoader)} using
	 * a {@link ByteArrayInputStream} to wrap the array.
	 * 
	 * @param objectData
	 *            the serialized object, must not be null
	 * @param loader
	 *            The classloader to use
	 * 
	 * @return the deserialized object
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>objectData</code> is <code>null</code>
	 * @throws SerializationException
	 *             (runtime) if the serialization fails
	 */
	public static Object deserialize(byte[] objectData, ClassLoader loader) throws SerializationException {
		return doDeserialize(wrap(objectData), loader, Thread.currentThread().getContextClassLoader(), SerializationUtil.class.getClassLoader());
	}

	/**
	 * Deserializes an object from the specified stream using the Thread Context
	 * ClassLoader (TCCL). Delegates to {@link #doDeserialize}
	 * 
	 * @param inputStream
	 *            the serialized object input stream, must not be null
	 * @return the deserialized object
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>inputStream</code> is <code>null</code>
	 * @throws SerializationException
	 *             (runtime) if the serialization fails
	 */
	public static Object deserialize(InputStream inputStream) throws SerializationException {
		return doDeserialize(inputStream, Thread.currentThread().getContextClassLoader(), SerializationUtil.class.getClassLoader(), null);
	}

	/**
	 * Deserializes an object from the specified stream using the Thread Context
	 * ClassLoader (TCCL). If there is no TCCL set, the classloader of the
	 * calling class is used. The stream will be closed once the object is read.
	 * This avoids the need for a finally clause, and maybe also exception
	 * handling, in the application code. The stream passed in is not buffered
	 * internally within this method. This is the responsibility of the caller,
	 * if desired.
	 * 
	 * @param inputStream
	 *            the serialized object input stream, must not be null
	 * @param loader
	 *            The classloader to use
	 * 
	 * @return the deserialized object
	 * 
	 * @throws IllegalArgumentException
	 *             if <code>inputStream</code> is <code>null</code>
	 * @throws SerializationException
	 *             (runtime) if the serialization fails
	 */
	public static Object deserialize(InputStream inputStream, ClassLoader loader) throws SerializationException {
		return doDeserialize(inputStream, loader, Thread.currentThread().getContextClassLoader(), SerializationUtil.class.getClassLoader());
	}

	public static Object deserialize(String configDirectory, String fileName) {
		Object obj;
		String fullFilename = configDirectory + "/" + fileName;
		log.debug("Attempting to deserialize object from file: " + fullFilename);
		try {
			ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fullFilename)));
			obj = ois.readObject();
			ois.close();
		} catch (Exception e) {
			log.error("Failed while deserializing object (from file " + fullFilename + "): " + e.getMessage(), e);
			throw new RuntimeException("Failed while deserializing object (from file " + fullFilename + "): " + e.getMessage());
		}
		return obj;
	}

	public static Object doDeserialize(InputStream inputStream, ClassLoader loader, ClassLoader fallbackLoader1, ClassLoader fallbackLoader2) throws SerializationException {
		if (inputStream == null) {
			throw new IllegalArgumentException("The InputStream must not be null");
		}
		log.trace("Starting deserialization of object");
		try {
			CustomObjectInputStream in = new CustomObjectInputStream(inputStream, loader, fallbackLoader1, fallbackLoader2);
			try {
				return in.readObject();
			} catch (ClassNotFoundException e) {
				throw new SerializationException("could not deserialize", e);
			} catch (IOException e) {
				throw new SerializationException("could not deserialize", e);
			} finally {
				try {
					in.close();
				} catch (IOException ignore) {
					// ignore
				}
			}
		} catch (IOException e) {
			throw new SerializationException("could not deserialize", e);
		}
	}

	// Clone
	// -----------------------------------------------------------------------
	/**
	 * Deep clone an <code>Object</code> using serialization. This is many times
	 * slower than writing clone methods by hand on all objects in your object
	 * graph. However, for complex object graphs, or for those that don't
	 * support deep cloning this can be a simple alternative implementation. Of
	 * course all the objects must be <code>Serializable</code>.
	 * 
	 * @param object
	 *            the <code>Serializable</code> object to clone
	 * @return the cloned object
	 * 
	 * @throws SerializationException
	 *             (runtime) if the serialization fails
	 */
	public static Object deepclone(Serializable object) throws SerializationException {
		log.trace("Starting clone through serialization");
		if (object == null) {
			return null;
		}
		return deserialize(serialize(object), object.getClass().getClassLoader());
	}
	
}
