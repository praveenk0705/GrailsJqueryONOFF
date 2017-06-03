package j

class AbcController {

    def index = {
		
		
		/*def n = new Mmmm() 
		n.name  = "praveen" 
		n.save();
		
		def nnn = Mmmm.findAllByName("praveen");
		//println nnn;
		//def homePageList=GrupurHomePage.executeQuery( "select  a.grupurKeyy from GrupurHomePage a")
		//
		def a = Mmmm.executeQuery("select name from Mmmm where id ='1217'")
		//println a;
		
		def i  = a.get(0)
		def o =i.getClass()
		println o;
		if(o=="java.lang.String")
		flash.message = "hello world"
		redirect (action:"a.gsp")*/
		flash.message = "hello world"
    }
	
	def db={
		if(!grails.util.GrailsUtil.environment.equalsIgnoreCase("PRODUCTION")){
			org.hsqldb.util.DatabaseManagerSwing.main(new String[0])
			Thread.sleep 100000
			}
	
}
}
