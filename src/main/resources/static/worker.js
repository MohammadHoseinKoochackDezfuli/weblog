function postMaker(res)
{
    return `<a style="width: 50%;margin-left: 20px" href="/post?slug=`+res.slug+`"><div>
                <div class="weblog">
                    <h4>`+res.title+`</h4>
                    <p>`+res.excerpt+`</p>
                    <span><span>`+res.views+`</span> مشاهده</span>
                </div>
            </div></a>`;
}
function listPostMaker(res)
{
    var text="";
    for(var i=0;i<res.length;i++)
    {
        if(i%2==0)
        {
            text+=`
        <div style="height: 20px;"></div>
        <div style="display: flex;">`;
        }
        else
        {
            text+=`<div style="width: 20px;"></div>`;
        }
        text+=postMaker(res[i]);
        if(i%2==1)
        {
            text+="</div>";
        }
    }
    return text;
}
function categoryMaker(res)
{
    return `<a style="width: 50%;margin-left: 20px" href="/category?slug=`+res.slug+`"><div>
                <div class="category">
                    <h4>`+res.name+`</h4>
                    <p>`+res.description+`</p>
                </div>
            </div></a>`;
}
function listCategoryMaker(res)
{
    var text="";
    for(var i=0;i<res.length;i++)
    {
        if(i%2==0)
        {
            text+=`
        <div style="height: 20px;"></div>
        <div style="display: flex;">`;
        }
        else
        {
            text+=`<div style="width: 20px;"></div>`;
        }
        text+=categoryMaker(res[i]);
        if(i%2==1||i==res.length-1)
        {
            text+="</div>";
        }
    }
    return text;
}
function round(number)
{
    var newNumber=number[0];
    for(var i=0;i<number.length-1;i++)
    {
        newNumber+="0";
    }
    return newNumber;
}