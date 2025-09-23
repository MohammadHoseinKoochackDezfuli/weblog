function tableMaker(res,td,th)
{
    res.sort(function (a,b){
        return a.id-b.id;
    })
    var text="<tr>";
    for(var x=0;x<td.length;x++)
    {
        text+="<td>"+td[x]+"</td>";
    }
    text+="</tr>";
    for(var y=0;y<res.length;y++)
    {
        text+="<tr>";
        for(var x=0;x<th.length;x++)
        {
            try {
                text+="<th>"+eval(th[x])+"</th>";
            }
            catch (e)
            {
                console.log([x,y,e,th[x]])
            }
        }
        text+="</tr>";
    }
    return text;
}