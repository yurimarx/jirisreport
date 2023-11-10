Class dc.jirisreport.SampleReportGenerator
{

ClassMethod CreateSampleReport() As %Status
{
    Set Parameters = {}

    Set result = ##class(dc.jirisreport.JIRISReport).GenerateReportAsFile(
        "jdbc:IRIS://localhost:1972/IRISAPP", 
        $SYSTEM.Util.BinaryDirectory()_"samplereports/sampledata.jrxml",
        "/tmp/outsample.pdf",
        Parameters 
    )
    
    write result  
    return result
}

ClassMethod CreateFilteredSampleReport() As %Status
{
    Set Parameters = {}
    Set Parameters.ptName = "b"
    Set Parameters.ptCompany = "b"
    
    Set result = ##class(dc.jirisreport.JIRISReport).GenerateReportAsFile(
        "jdbc:IRIS://localhost:1972/irisapp", 
        $SYSTEM.Util.BinaryDirectory()_"jirisreport/filteredsample.jrxml",
        $SYSTEM.Util.BinaryDirectory()_"jirisreport/out.pdf",
        Parameters
    )
    
    write result  
    return result
}

}
