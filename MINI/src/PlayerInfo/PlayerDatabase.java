package PlayerInfo;


import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Driver;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Application;





@Path("/hello")
public class PlayerDatabase {
@Path("/login")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
public String login(Playerlogin m )
{
	ResultSet rs = null;
	Statement stmt=null;
	String r="f";
	//System.out.println("HIII");
	System.out.println("hello login");
	try {
		System.out.println("+++");
		//System.out.println(m.getUserName());
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		String sql= "SELECT * FROM playerrecord WHERE Username = '"+m.getUserName()+"'";
		//Statement stmt = 
		PreparedStatement preparedStmt = conn.prepareStatement(sql);
		//preparedStmt.setString (1, m.getUserName());
		//preparedStmt.setString (2, m.getPassword());
		/*preparedStmt.setString (3, m.getUserName());
		preparedStmt.setString (4, m.getPassword());*/
		rs = preparedStmt.executeQuery(sql);
		/*System.out.println(rs.next());
	if(!rs.next()) {
		return "fUsername not found";
	}*/
	String uName = "";
	String pass = "";
	System.out.println(m.getPassword());
	//System.out.println(rs.next());
	while(rs.next()) { 
		 uName = rs.getString("Username");
		 pass=rs.getString("Password");
		 System.out.println("++"+uName);
		 System.out.println("=="+pass);
	}
    if(uName!=""&&pass.equals(m.getPassword())) return "hello";
    else return r;
        
	
	}
catch (Exception e){
	System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	//String resource="hi  ";
	//return resource;
}


@Path("/create")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)

public String createUser(PlayerAJ m )
{
	Statement stmt=null;
	//System.out.println("HIII");
	System.out.println("hello "+m.getFirstName()+" "+m.getLastName());
	try {
		System.out.println("+++");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		System.out.println("Inserting records into tables+++++");
		String sql="INSERT INTO playerrecord (FirstName,LastName,UserName,Password) "+"VALUES (?,?,?,?)";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);
		preparedStmt.setString (1, m.getFirstName());
		preparedStmt.setString (2, m.getLastName());
		preparedStmt.setString (3, m.getUserName());
		preparedStmt.setString (4, m.getPassword());
		preparedStmt.execute();			    	
		}
	catch (Exception e){
		System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	String resource="hi  "+m.getFirstName()+" "+m.getLastName();
		return resource;
	}
	

@Path("/ticscore")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)

public String ticscore(TicScore m )
{
	Statement stmt=null;
	//System.out.println("HIII");
	System.out.println("hello ticscore ");
	System.out.println(m.getTicdbscore());
	System.out.println(m.getUserName());
	try {
		System.out.println("+++");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		System.out.println("Inserting records into tables+++++");
		String sql="UPDATE playerrecord SET ScoreTTT = '"+m.getTicdbscore()+"' WHERE Username = '"+m.getUserName()+"'";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);
		preparedStmt.execute();			    	
		}
	catch (Exception e){
		System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	String resource="hi  ";
		return resource;
	}
		

@Path("/simonscore")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)

public String simonscore(SimonScore m )
{
	Statement stmt=null;
	//System.out.println("HIII");
	System.out.println("hello simonscore ");
	System.out.println(m.getSimondbscore());
	System.out.println(m.getUserName());
	try {
		System.out.println("+++");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		System.out.println("Inserting records into tables+++++");
		String sql="UPDATE playerrecord SET ScoreSimon = '"+m.getSimondbscore()+"' WHERE Username = '"+m.getUserName()+"'";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);
		preparedStmt.execute();			    	
		}
	catch (Exception e){
		System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	String resource="hi  ";
		return resource;
	}



@Path("/sudokuscore")
@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)

public String sudokuscore(SudokuScore m )
{
	Statement stmt=null;
	//System.out.println("HIII");
	System.out.println("hello sudokuscore ");
	System.out.println(m.getSudokudbscore());
	System.out.println(m.getUserName());
	try {
		System.out.println("+++");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		System.out.println("Inserting records into tables+++++");
		String sql="UPDATE playerrecord SET ScoreSudoku = '"+m.getSudokudbscore()+"' WHERE Username = '"+m.getUserName()+"'";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);
		preparedStmt.execute();			    	
		}
	catch (Exception e){
		System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	String resource="hi  ";
		return resource;
}


@Path("/ticscoreboard")
@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String ticscoreboard()
{
	String r="f";
	System.out.println("hello tic scoreboard");
	try {
		System.out.println("+++");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		String sql= "SELECT Username,ScoreTTT FROM playerrecord ORDER BY ScoreTTT DESC";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);

		ResultSet rs = preparedStmt.executeQuery(sql);

		ArrayList<String> ar = new ArrayList<>();
	//System.out.println(rs.next());
	while(rs.next()) { 
		ar.add(rs.getString("Username"));
		ar.add(rs.getString("ScoreTTT"));
	}
	System.out.println(ar);
	String var = "{" + "\"Tic Tac Toe\": [";

	/* {
	"Tic Tac Toe": [{
		"Username": "aos",
		"ScoreTTT": "10"
	},
	{
		"Username": "meg",
		"ScoreTTT": "10"
	}
]ar.get(i)
}*/
	for(int i=0;i<ar.size();i++) {
		
		var=var+"{ \"Username\": \""+ar.get(i)+"\",";
		i++;
		var=var+"\"ScoreTTT\": \""+ar.get(i)+"\"}";
		if(i!=ar.size()-1) var=var+",";
		
	}
	var=var+"]}";
	System.out.println(var);
  return var;
        
	
	}
catch (Exception e){
	System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	//String resource="hi  ";
	//return resource;
}


@Path("/simonscoreboard")
@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String simonscoreboard()
{
	String r="f";
	System.out.println("hello simon scoreboard");
	try {
		System.out.println("+++");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		String sql= "SELECT Username,ScoreSimon FROM playerrecord ORDER BY ScoreSimon DESC";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);

		ResultSet rs = preparedStmt.executeQuery(sql);

		ArrayList<String> ar = new ArrayList<>();
	//System.out.println(rs.next());
	while(rs.next()) { 
		ar.add(rs.getString("Username"));
		ar.add(rs.getString("ScoreSimon"));
	}
	System.out.println(ar);
	String var = "{" + "\"Simon\": [";

	for(int i=0;i<ar.size();i++) {
		
		var=var+"{ \"Username\": \""+ar.get(i)+"\",";
		i++;
		var=var+"\"ScoreSimon\": \""+ar.get(i)+"\"}";
		if(i!=ar.size()-1) var=var+",";
		
	}
	var=var+"]}";
	System.out.println(var);
  return var;
        
	
	}
catch (Exception e){
	System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	//String resource="hi  ";
	//return resource;
}




@Path("/sudokuscoreboard")
@GET
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public String sudokuscoreboard()
{
	String r="f";
	System.out.println("hello sudoku scoreboard");
	try {
		System.out.println("+++");
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Connecting to database");
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/player","root","akash");
		System.out.println("Connected");
		String sql= "SELECT Username,ScoreSudoku FROM playerrecord ORDER BY ScoreSudoku DESC";
		PreparedStatement preparedStmt = conn.prepareStatement(sql);

		ResultSet rs = preparedStmt.executeQuery(sql);

		ArrayList<String> ar = new ArrayList<>();
	//System.out.println(rs.next());
	while(rs.next()) { 
		ar.add(rs.getString("Username"));
		ar.add(rs.getString("ScoreSudoku"));
	}
	System.out.println(ar);
	String var = "{" + "\"Sudoku\": [";

	for(int i=0;i<ar.size();i++) {
		
		var=var+"{ \"Username\": \""+ar.get(i)+"\",";
		i++;
		var=var+"\"ScoreSudoku\": \""+ar.get(i)+"\"}";
		if(i!=ar.size()-1) var=var+",";
		
	}
	var=var+"]}";
	System.out.println(var);
  return var;
        
	
	}
catch (Exception e){
		System.out.println(e);
		System.out.println("HIII");
		String x="f"+e.getMessage();
		return x;
	}
	//String resource="hi  ";
	//return resource;
}
}		






