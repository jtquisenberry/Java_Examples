

while(m.find())
{
    int matchStart = m.start();
    int matchEnd = m.end();
    String value = "";
    int i = 0;
    
    while (i <= m.groupCount()) 
{

System.out.println(i + " " + m.group(i));
if((i > 0) && (m.group(i) != null))
{
     value += m.group(i) + " - ";
}

i++;
}
