Class dc.jirisreport.JIRISReport Extends %RegisteredObject
{

ClassMethod GenerateReportAsFile(JdbcURL As %String, ReportFilePath As %String, OutFilePath As %String, Parameters As %DynamicObject, Format As %String = "PDF") As %Status
{
    set javaGate = $system.external.getJavaGateway()  
    do javaGate.addToPath($SYSTEM.Util.BinaryDirectory()_"jirisreport.jar")
    set jirisreport = javaGate.new("jirisreport.JIrisReport") 
    
    Set cred = ##class(Ens.Config.Credentials).%OpenId("ReportCreds")
    Set username = cred.Username 
    Set password = cred.Password 

    If password = "" {
        set password = "SYS"
    }
    
    If Format = "DOCX" {
        set result = jirisreport.generateToWordFile(ReportFilePath, OutFilePath, JdbcURL, Parameters.%ToJSON(), username, password)
    } Else {
        set result = jirisreport.generateToPDFFile(ReportFilePath, OutFilePath, JdbcURL, Parameters.%ToJSON(), username, password)
    }
    
    return result
}

}
