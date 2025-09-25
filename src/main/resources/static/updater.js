var l;
const params = new URLSearchParams(window.location.search);
const id = params.get("id");
function text(list)
{
    l=list;
    var text="";
    for(var i=0;i<list.length;i++)
    {
        text+="<div><label class='form-label' for='i"+i+"'>"+list[i]+"</label><input class='form-control' placeholder='"+list[i]+" را وارد کنید.' id='i"+i+"'></div>";
    }
    text+="<button onclick='SET();' class='btn btn-primary'>ok</button>";
    document.getElementById("text").innerHTML=text;
}
function SET()
{
    var content="";
    var f="http://localhost:8083/"+document.getElementById("h").innerHTML+"/update?id="+id;
    for(var i=0;i<l.length;i++)
    {
        if(l[i]=="content")
        {
            content=document.getElementById("i" + i).value;
        }
        else {
            f += "&" + l[i] + "=" + document.getElementById("i" + i).value;
        }
    }
    const data={
      content:content
    };
    fetch(f, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });
}