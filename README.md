![PrimeFaces icon](https://www.primefaces.org/wp-content/uploads/2016/10/prime_logo_new.png)

# PrimeFaces TabView Test - To reproduce JSF1007 error.

This is a sample maven project that uses <strong>Latest PrimeFaces Release</strong> version (The original code is downloaded from PrimeFaces test package). It is used to reproduce PrimeFaces TabView issues when dynamic Tabs were used. Especially when conditional tabs with different <ui:include> that depends on different condition, that means based on exist backend bean conditions to render different include jsf view (**.xhtml) when it is need. 

Any one can fork this code to test. <strong>Please make sure that project is runnable with the command below.</strong>

You can execute the sample with <strong>mvn jetty:run</strong> command and hit <strong>http://localhost:8080/</strong> to run the page.

### Typical error information on Jetty:

com.sun.faces.util.Util checkIdUniqueness SEVERE: JSF1007: Duplicate component ID form:contract_tabview:id found in view.

### Payara throws other error:

[2024-10-04T15:59:07.207+1000] [Payara 6.2024.9] [SEVERE] [faces.duplicate_component_id_error] [jakarta.enterprise.resource.webcontainer.faces.application] [tid: _ThreadID=97 _ThreadName=http-thread-pool::http-listener-1(5)] [timeMillis: 1728021547207] [levelValue: 1000] [[
JSF1007: Duplicate component ID form:contract_tabview:id found in view.]]
...............................
[2024-10-04T15:59:07.210+1000] [Payara 6.2024.9] [SEVERE] [] [jakarta.enterprise.resource.webcontainer.faces.application] [tid: _ThreadID=97 _ThreadName=http-thread-pool::http-listener-1(5)] [timeMillis: 1728021547210] [levelValue: 1000] [[

[2024-10-04T15:59:07.220+1000] [Payara 6.2024.9] [SEVERE] [] [jakarta.enterprise.resource.webcontainer.faces.application] [tid: _ThreadID=97 _ThreadName=http-thread-pool::http-listener-1(5)] [timeMillis: 1728021547220] [levelValue: 1000] [[
Error Rendering View[/tabViews/cniTabView.xhtml]
java.lang.IllegalStateException: Component ID form:contract_tabview:id has already been found in the view.

Error code number is same: JSF1007

## Note: for payara test case

Have to comment out all Jetty related dependency and enable Payara related dependency.

## Discussion

From Payara exception we can see, Even in Jakarta EE-10, TabView not really support dynamic Tab generation (looks JSF not assign correct Tab component id for each possible Tab). If that's the case, that means, TabView Spec need expend to support this features in the future.

# Primefaces_test

Please comment and advise any work around is welcome!!!!!