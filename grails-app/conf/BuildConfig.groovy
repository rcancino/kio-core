grails.servlet.version = "3.0" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.work.dir = "target/work"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.fork = [
    // configure settings for compilation JVM, note that if you alter the Groovy version forked compilation is required
    //  compile: [maxMemory: 256, minMemory: 64, debug: false, maxPerm: 256, daemon:true],

    // configure settings for the test-app JVM, uses the daemon by default
    test: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, daemon:true],
    // configure settings for the run-app JVM
    run: [maxMemory: 1024, minMemory: 64, debug: false, maxPerm: 1024],
    // configure settings for the run-war JVM
    war: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256, forkReserve:false],
    // configure settings for the Console UI JVM
    console: [maxMemory: 768, minMemory: 64, debug: false, maxPerm: 256]
]

grails.project.dependency.resolver = "maven" // or ivy
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
        excludes "grails-docs"
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        mavenLocal()
        grailsCentral()
        mavenCentral()

        mavenRepo 'http://repo.spring.io/milestone'
        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        mavenRepo "http://dl.bintray.com/rcancino/econta" 
        mavenRepo "http://dl.bintray.com/rcancino/maven" 
        mavenRepo "http://dl.bintray.com/rcancino/cfdi"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.
        runtime 'mysql:mysql-connector-java:5.1.29'
        // runtime 'org.postgresql:postgresql:9.3-1101-jdbc41'
        test "org.grails:grails-datastore-test-support:1.0-grails-2.4"
        compile "org.jadira.usertype:usertype.jodatime:2.0"

        compile 'org.apache.xmlbeans:xmlbeans:2.4.0'
        compile 'axis:axis:1.4'
        compile 'org.apache.commons:commons-compress:1.1'
        compile 'net.glxn:qrgen:1.2'
        compile 'org.bouncycastle:bcprov-jdk14:1.45'
        //compile 'cfdi:cfdi:3.2'
        //compile 'com.edicom.ediwinws:cfdiClient:1.0'
        //compile 'nomina:nomina:1.0'
        
        // Nueva implementacion de CFDI
        // compile 'lx.cfdi:v32:1.0.1'
        compile 'lx.cfdi:v33:1.0.5'

        build('org.grails:grails-docs:2.4.3') {
            excludes 'itext'
        }
        
    }

    plugins {

        //UPGRADE TO 2.4.4
        compile ":scaffolding:2.1.2"
        compile ':cache:1.1.8'
        compile ":asset-pipeline:1.9.9"
        runtime ":hibernate4:4.3.5.4" // or ":hibernate:3.6.10.16"
        //runtime ":hibernate4:4.3.6.1" // NO SIRVE
        
        
        // plugins for the compile step
        //compile ":scaffolding:2.1.1"
        //compile ':cache:1.1.6'
        //compile ":asset-pipeline:1.8.11"
        
        
        
        // plugins for the build system only
        //build ":tomcat:7.0.54"
        compile ":jetty:3.0.0"

        // plugins needed at runtime but not for compilation
        
        runtime ":database-migration:1.4.0"
        runtime ":jquery:1.11.1"
        compile ":build-test-data:2.2.2"
        runtime ":twitter-bootstrap:3.2.0.2"
        compile ":font-awesome-resources:4.2.0.0"
		compile ":platform-core:1.0.0"
        compile ":fields:1.4"
        
        compile ":joda-time:1.5"
		
		
        compile ":standalone:1.2.3"
        
        //compile ":jasper:1.10.0"
        compile ":jasper:1.11.0-SNAPSHOT"
        compile ":spring-security-core:2.0-RC4"
        //compile ":spring-security-core:2.0-RC3"
        
        compile ":console:1.5.1"
        compile ":mail:1.0.7"
        
        
        compile ":quartz:1.0.2"

        
        
        // Uncomment these to enable additional asset-pipeline capabilities
        //compile ":sass-asset-pipeline:1.9.0"
        //compile ":less-asset-pipeline:1.10.0"
        //compile ":coffee-asset-pipeline:1.8.0"
        //compile ":handlebars-asset-pipeline:1.3.0.3"
    }
}
grails.plugin.standalone.useJetty = true