var fileUpload = (function() {
    //附件
    var files = {};
    function uploadFile(id, fileSrc, extensions,sizeLimit) {
        $("#"+id).fineUploader({
            request: {
                endpoint: contextPath + '/mongoFile/uploadFile/' + fileSrc
            },
            template: "qq-template",
            validation: {
                allowedExtensions: extensions,
                sizeLimit: sizeLimit
            },
            retry: {
                showButton: true
            },
            deleteFile: {
                enabled: true,
                endpoint: contextPath + '/mongoFile/delete/' + fileSrc
            },
            text: {
                uploadButton: "上传附件",
                waitingForResponse: "上传中",
                failedUpload: "上传失败",
                deleteFile: "删除"
            }
        }).on('error', function (event, id, name, reason) {
            msgUtil.alert(name + "文件上传失败" + reason);
        }).on('complete', function (event, id, name, responseJSON) {
            debugger;
            var fileJson = responseJSON.fileJson;
            files[fileJson.id] = fileJson;
        }).on('delete', function (event, id) {

        }).on('deleteComplete', function (event,id, xhr, isError) {
            var responseJSON = JSON.parse(xhr.response);
            delete files[responseJSON.fileId];
        });
    }

    function getFileJson() {
        debugger;
        var fileId;
        var attachments = [];
        for (var i in files) {
            attachments.push(files[i]);
            fileId = files[i];
        }
        return JSON.stringify(attachments);
    }
    function initialFiles(attachmentId) {
        var attachment = $('#' + attachmentId).val();
        if ($.isEmpty(attachment)) {
            return;
        }
        var attachments = JSON.parse(attachment.toString());
        for (var i in attachments) {
            var file = attachments[i];
            files[file.id] = file;
        }
    }
    
    function deleteAttchement(attId,fileId) {
        msgUtil.confirm("确认删除?",function() {
            $.getJsonByUrl({
                url : "/mongoFile/deleteAttchement/"+fileId,
                callback : function(data) {
                    if (data.result) {
                        $("#"+attId+"-div").remove();
                    } else {
                        msgUtil.alert(data.message);
                    }
                }
            });
            if ($.isEmpty(fileId)) {
                return;
            }
            var attachment = $('#attachment').val();
            if ($.isEmpty(attachment)) {
                return;
            }
            var attachments = JSON.parse(attachment.toString());
            files = {};
            for (var i in attachments) {
                var file = attachments[i];
                files[file.id] = file;
            }
            delete files[fileId];
            $('#attachment').val(getFileJson());
        });

    }

    function download(id) {
        document.location.href=contextPath + "/mongoFile/download/" + id;
    }

    return {
        uploadFile : uploadFile,
        download : download,
        initialFiles:initialFiles,
        deleteAttchement:deleteAttchement,
        getFileJson:getFileJson
    };
})();
