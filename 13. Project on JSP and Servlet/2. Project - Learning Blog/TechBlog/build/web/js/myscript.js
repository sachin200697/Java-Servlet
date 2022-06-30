function doLike(pid, uid){
    console.log(pid, uid);
    
    const d = {
        pid,
        uid,
        operation: "like"
    };
    
    $.ajax({
       url: "LikeServlet",
       data: d,
       success: function(data, textStatus, jqXHR){
           console.log(data);
           let c = parseInt($("#count-like").html());
           c = c + 1;
           $("#count-like").text(c);
       },
       error: function(jqXHR, textStatus, errorThrown){
           console.log(jqXHR);
       }
    });
}