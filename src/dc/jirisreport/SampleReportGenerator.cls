Class dc.jirisreport.SampleReportGenerator
{

ClassMethod CreateSampleReport() As %Status
{
    set javaGate = $system.external.getJavaGateway() 
    set irisreportpath = $System.Util.GetEnviron("JIRISREPORT_PATH")
    do javaGate.addToPath(irisreportpath)
    set jirisreport = javaGate.new("jirisreport.JIrisReport") 
    set reportIn = "/home/irisowner/dev/samplereports/sampledata.jrxml"
    set reportOut = "/home/irisowner/dev/outFull.pdf"
    set parameters = {}
    
    set result = jirisreport.generateToPDFFile(reportIn, reportOut, "jdbc:IRIS://iris:1972/irisapp", parameters.%ToJSON(), "_SYSTEM", "SYS")
  
    write result  
    return result
}

ClassMethod CreateFilteredSampleReport() As %Status
{
    set javaGate = $system.external.getJavaGateway()  
    set irisreportpath = $System.Util.GetEnviron("JIRISREPORT_PATH")
    do javaGate.addToPath(irisreportpath)
    set jirisreport = javaGate.new("jirisreport.JIrisReport") 
    set reportIn = "/home/irisowner/dev/samplereports/filteredsample.jrxml"
    set reportOut = "/home/irisowner/dev/out.docx"
    
    set parameters = {}
    set parameters.ptCompany = "b"
    set parameters.ptName = "b"
    
    set result = jirisreport.generateToWordFile(reportIn, reportOut, "jdbc:IRIS://iris:1972/irisapp", parameters.%ToJSON(), "_SYSTEM", "SYS")
  
    write result  
    return result
}

ClassMethod Run(python As %Boolean = 1) As %Status
{
    return:python ..Python()
    return:'python ..ObjectScript()
}

ClassMethod ObjectScript() As %Status
{
    set a=42 
    write "Hello World! from ",$CLASSMETHOD("dc.sample.ObjectScript","%ClassName",1)," in ObjectScript language",!
    write "This is InterSystems IRIS with version ",$zv,!
    write "Current time is: "_$zdt($now(),3,,6),!
    return a
}

ClassMethod Python() As %Status [ Language = python ]
{
import iris    
from datetime import datetime
a=42 
print("Hello World! from",iris.cls('dc.sample.ObjectScript')._ClassName(1),"in Python language")
print("This is InterSystems IRIS with version",iris.system.Version.GetVersion())
print("Current time is:",datetime.now())
return a
}

}
