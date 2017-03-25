define(['jQuery'], function(jQuery) {
    jQuery.extend({
        includePath: '',
        include: function(file) {
           var files = typeof file == "string" ? [file]:file;
           for (var i = 0; i < files.length; i++) {
               var name = files[i].replace(/^\s|\s$/g, "");
               var att = name.split('.');
               var ext = att[att.length - 1].toLowerCase();
               var isCSS = ext == "css";
               var tag = isCSS ? "link" : "script";
               var attr = isCSS ? " type='text/css' rel='stylesheet' " : " language='javascript' type='text/javascript' ";
               var link = (isCSS ? "href" : "src") + "='" + $.includePath + "/" + name + "'";
               if ($(tag + "[" + link + "]").length == 0) {
                   jQuery('head').append("<" + tag + attr + link + "></" + tag + ">");
               }
            }
        },
        confirm : function(message, callback) {
            var sourceData = "<div id='dialog' class='dialog-container'><div class='dialog'><div class='header'><span>" + dialogTitle + ":</span>"
                + "<a id='closeId' class='closeId dialog-close'>X</a></div><div class='infor'><div>"
                + message
                + "</div></div>"
                + "<div class='operator'><a id='confirmId' class='closeId'>" + yes + "</a><a id='cancelId' class='closeId'>" + no + "</a></div></div></div>";
            $('body').append(sourceData);
            var elem = $('a.closeId');
            elem.bind('click', function() {
                if (this.id == 'confirmId') {
                    callback();
                }
                $('#dialog').remove();
            });
        },
        showMsg : function(msg, callback) {
            $('#topContainerId').append(
                "<div id=dialogMsg class='message'><center><label>" + msg + "</label></center></div>");
            setTimeout(function() {
                $('#dialogMsg').remove();
                callback();
            }, 2000);
        },
        showErrorMsg  : function(msg, callback) {
            $('#topContainerId').append(
                "<div id=dialogMsg class='message'><center><label class='color-red'>" + msg + "</label></center></div>");
            setTimeout(function() {
                $('#dialogMsg').remove();
                callback();
            }, 2000);
        }
    });
    $.includePath = '/HomeWork' +'/source/js/lib/dialog';
    $.include(['dialog.css']);
});