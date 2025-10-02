var l;
const params = new URLSearchParams(window.location.search);
const id = params.get("id");
function text(list)
{
    fetch("http://localhost:8083/"+document.getElementById("h").innerHTML+"/findAdminById?id="+id)
        .then(res=>res.json())
        .then(res=>{
            l=list;
            var text="";
            for(var i=0;i<list.length;i++)
            {
                text+="<div><label class='form-label' for='i"+i+"'>"+list[i]+"</label><input value='"+eval("res."+list[i])+"' class='form-control' placeholder='"+list[i]+" را وارد کنید.' id='i"+i+"'></div>";
            }
            text+="<button onclick='SET();' class='btn btn-primary'>ok</button>";
            document.getElementById("text").innerHTML=text;
        })
}
function SET()
{
    var data={
        id:id
    };
    var f="http://localhost:8083/"+document.getElementById("h").innerHTML+"/update";
    for(var i=0;i<l.length;i++)
    {
        eval("data."+l[i]+"=document.getElementById('i"+i+"').value")
    }
    console.log(data)
    fetch(f, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(data)
    });
}