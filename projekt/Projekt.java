package projekt;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Insets;



public class Projekt extends Application
{   
    
    PreparedStatement preparedStatement;
    Connection con;
    Integer czyAdmin = 0;
    Integer czyKlient = 0;
    int ile_kolumn;
    int ile_kolumn_klient;
    int ile_kolumn_adres;
    int ile_kolumn_lekarz;
    int ile_kolumn_sprzet;
    int ile_kolumn_recepta;
    int ile_kolumn_rejestracja;
    int ile_kolumn_skierowanie;
    int ile_kolumn_zwolnienie;
    int ile_kolumn_wizyta;
    int ile_kolumn_procedura;
    int ile_kolumn_kwerenda;
    int ile_kolumn_wyzwalacz;
    
    @Override
    public void start(Stage stage) throws Exception
    {         
        
        GridPane okno = new GridPane();
        okno.setId("okno");
        okno.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 


         Label succes = new Label("Udalo sie polaczyc z baza");
         Label fail = new Label("Blad sterownika");
         Label failPolaczenie = new Label("Blad polaczenia");
       
         
         Label blad_logowania = new Label("Login lub hasło są niepoprawne");
         blad_logowania.setId("log_error");
         blad_logowania.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());


         
         
         Label naglowek_panel_log = new Label("PANEL LOGOWANIA");
         naglowek_panel_log.setId("nag_pan_log");
         naglowek_panel_log.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_admin_panel = new Label("Zalogowany jako administrator");
         naglowek_admin_panel.setId("nag_pan_log");
         naglowek_admin_panel.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label naglowek_user_panel = new Label("Zalogowany jako uzytkownik");
         naglowek_user_panel.setId("nag_pan_log");
         naglowek_user_panel.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
         
        stage.initStyle(StageStyle.UNDECORATED);

        HBox gorny_panel = new HBox();  // pojemnik na logo i naglowek

        gorny_panel.setMinSize(800,100);   //odległości w poziomie       
        gorny_panel.getChildren().addAll(naglowek_panel_log);
        gorny_panel.setAlignment(Pos.CENTER);
     //   gorny_panel.setStyle("-fx-background-color: green;");
        okno.add(gorny_panel, 0, 0, 1, 1);
                   
        
        Button log_button=new Button("Zaloguj");
        log_button.setMinSize(159,38);
        log_button.setId("log_button");
        log_button.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
       // okno.add(menu_poz, 0, 1, 1, 1);
        
      
        
        HBox kontener= new HBox();
        kontener.setMinWidth(200);
        kontener.setMinHeight(200);

        
        okno.add(kontener, 0, 2, 1, 4);
        //////////////////////////////// ADMIN PRZYCISKI
        Button a_dodaj=new Button("Dodaj");
        a_dodaj.setMinSize(159,38);
        a_dodaj.setId("menu_button");
        a_dodaj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        Button a_usun=new Button("Usuń");
        a_usun.setMinSize(159,38);
        a_usun.setId("menu_button");
        a_usun.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button a_edytuj=new Button("Edytuj");
        a_edytuj.setMinSize(159,38);
        a_edytuj.setId("menu_button");
        a_edytuj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button a_odczyt=new Button("Odczytaj");
        a_odczyt.setMinSize(159,38);
        a_odczyt.setId("menu_button");
        a_odczyt.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        
         
        Button wyloguj=new Button("Wyloguj");
        wyloguj.setMinSize(159,38);
        wyloguj.setId("menu_button");
        wyloguj.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        ////////////////////////////////////////////////// KLIENT PRZYCISKI
        
        Button k_tabela=new Button("Odczyt tabel");
        k_tabela.setMinSize(159,38);
        k_tabela.setId("menu_button");
        k_tabela.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
        Button k_kwerenda=new Button("Odczytaj kwerende");
        k_kwerenda.setMinSize(159,38);
        k_kwerenda.setId("menu_button");
        k_kwerenda.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button k_procedura=new Button("Odczytaj procedure");
        k_procedura.setMinSize(159,38);
        k_procedura.setId("menu_button");
        k_procedura.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Button k_wyzwalacz=new Button("Odczytaj wyzwalacz");
        k_wyzwalacz.setMinSize(159,38);
        k_wyzwalacz.setId("menu_button");
        k_wyzwalacz.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
        Label menuLabel = new Label("MENU");
        menuLabel.setId("menuLabel");
        menuLabel.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
              
        
        
        VBox panel_przyciski = new VBox();
        panel_przyciski.setMinSize(200,400);
        panel_przyciski.setSpacing(30);
        panel_przyciski.setAlignment(Pos.CENTER);
        
        kontener.getChildren().add(panel_przyciski);
     
        
        VBox panel_dane= new VBox();
        panel_dane.setMinSize(600,200);
        panel_dane.setAlignment(Pos.CENTER);
        
        HBox panel_dane_srodek= new HBox();
        panel_dane_srodek.setStyle("-fx-background-color: lightgrey");
        panel_dane_srodek.setMinSize(500,300);
        panel_dane_srodek.setId("tabels");
        panel_dane_srodek.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        panel_dane_srodek.setAlignment(Pos.CENTER);
        
        HBox panel_login = new HBox();
        panel_login.setMinWidth(200);
         panel_login.setAlignment(Pos.CENTER_LEFT);
         panel_login.setSpacing(15);
         panel_login.setMinHeight(80);
         
         Label loginLabel = new Label("login");
         loginLabel.setId("logs");
         loginLabel.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         loginLabel.setMinWidth(100);
         TextField loginField = new TextField();
         loginField.setMinWidth(200);
         
         HBox panel_haslo = new HBox();
         panel_haslo.setMinWidth(200);
         panel_haslo.setAlignment(Pos.CENTER_LEFT);
         panel_haslo.setSpacing(15);
         panel_haslo.setMinHeight(80);
         
         Label hasloLabel = new Label("password");
         hasloLabel.setId("logs");
         hasloLabel.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         hasloLabel.setMinWidth(100);
         PasswordField hasloField = new PasswordField();
         hasloField.setMinWidth(200);
        
        
         panel_dane.getChildren().addAll(panel_login, panel_haslo, log_button);
         
         panel_login.getChildren().addAll(loginLabel, loginField);
         panel_haslo.getChildren().addAll(hasloLabel, hasloField);
        
        kontener.getChildren().add(panel_dane);
        
        
     
        
    

         HBox stopka=new HBox();
         stopka.setMinSize(800,100);
         
         stopka.setId("stopka");
         stopka.setAlignment(Pos.CENTER_RIGHT);
         stopka.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
         okno.add(stopka,0,6,1,1);
         
         Label autor= new Label("Autor:\n" +
                        "Szymon Dębski");
         autor.setId("autor");
         autor.setPadding(new Insets(5,0,20,0));
         
         autor.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         stopka.getChildren().add(autor);
          
         
         log_button.setOnAction(e->{ ///// logowanie przycisk
             
             
             Label loginWynik=new Label();
              loginWynik.setText(loginField.getText());
              String loginString=loginWynik.getText();
              loginField.clear();
              
              Label hasloWynik=new Label();
              hasloWynik.setText(hasloField.getText());
              String hasloString=hasloWynik.getText();
              hasloField.clear();

             try{
             
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

                String sql = "select login from administrator where login='"+loginString+"' and haslo='"+hasloString+"';";
                preparedStatement = con.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();
                 if (rs != null && !rs.isClosed() && rs.next())
                {
                    czyAdmin=1;
                }

                
              
            }
             catch(SQLException error_polaczenie) {
                panel_dane.getChildren().add(failPolaczenie);}
             catch(ClassNotFoundException error_sterownik) {
                panel_dane.getChildren().add(fail);}
             
             
              if(czyAdmin == 0){  
              try{
             
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

                String sql2 = "select login from uzytkownik where login='"+loginString+"' and haslo='"+hasloString+"';";
                preparedStatement = con.prepareStatement(sql2);
                ResultSet rs2 = preparedStatement.executeQuery();
                 if (rs2 != null && !rs2.isClosed() && rs2.next())
                {
                    czyKlient=1;
                }
              }
              catch(SQLException error_polaczenie) {
                panel_dane.getChildren().add(failPolaczenie);}
             catch(ClassNotFoundException error_sterownik) {
                panel_dane.getChildren().add(fail);}
                
              }
             
             
             
             
             if(czyAdmin == 0 & czyKlient == 0){
                 loginField.clear();
                hasloField.clear();
                panel_dane.getChildren().clear();
                panel_dane.getChildren().addAll(panel_login, panel_haslo, log_button);
                
                panel_dane.getChildren().add(blad_logowania);
                
             }
             else if( czyAdmin == 1){
             
             gorny_panel.getChildren().clear();
             gorny_panel.getChildren().add(naglowek_admin_panel);
             panel_dane.getChildren().clear();
             
             panel_przyciski.getChildren().clear();
             loginField.clear();
             hasloField.clear();
             
             panel_przyciski.getChildren().addAll(menuLabel, a_dodaj, a_usun, a_edytuj, a_odczyt, wyloguj);
             
             

            
             }
             else if( czyKlient == 1){

              try{
                        

                  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                        
                        
                        Statement query = con.createStatement();
                        String sql = "select id_uzytkownik from uzytkownik where login='"+loginString+"';";
                        
                        ResultSet rs = query.executeQuery(sql);
                        int userId = 0;
                        while(rs.next()) {
                        userId = Integer.valueOf(rs.getString(1));
                        }
                        
                         System.out.println("userId = " + userId);
                         
                        Statement query2 = con.createStatement();
                        String sql2 = "insert into logs values ( '"+loginString+"', getdate(), '"+userId+"');";
                            
                        query2.executeUpdate(sql2);

                        con.close();  
              
                        }
                    catch(SQLException error_polaczenie) {
                        panel_dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                        panel_dane.getChildren().add(fail);}   
                 
             gorny_panel.getChildren().clear();
             gorny_panel.getChildren().add(naglowek_user_panel);
             panel_dane.getChildren().clear();
             
             panel_przyciski.getChildren().clear();
             loginField.clear();
             hasloField.clear();
             
             panel_przyciski.getChildren().addAll(menuLabel, k_tabela, k_kwerenda, k_procedura, k_wyzwalacz, wyloguj);
        
                 
             }
          //   System.out.println("czyAdmin = " + czyAdmin + " czyKlient = " + czyKlient +" |||| logowanie");

             
         });
         
         
         
         wyloguj.setOnAction(e->{
             gorny_panel.getChildren().clear();
             gorny_panel.getChildren().add(naglowek_panel_log);
             
             panel_przyciski.getChildren().clear();
             loginField.clear();
             hasloField.clear();
             
             panel_dane.getChildren().clear();
             panel_dane.getChildren().addAll(panel_login, panel_haslo, log_button);
             
             panel_login.getChildren().clear();
             panel_haslo.getChildren().clear();
             panel_login.getChildren().addAll(loginLabel, loginField);
             panel_haslo.getChildren().addAll(hasloLabel, hasloField);
             
             czyAdmin=0;
             czyKlient=0;
        //     System.out.println("czyAdmin = " + czyAdmin + " czyKlient = " + czyKlient +" |||| wyloguj");
         });
         
         Label user_add = new Label("Dodaj użytkownika");
         user_add.setId("a_user");
         user_add.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label user_added = new Label("Dodano nowego użytkownika.");
         user_added.setId("user_succes");
         user_added.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Button add_user=new Button("Dodaj");
        add_user.setMinSize(120,30);
        add_user.setId("log_button");
        add_user.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
         Label user_exist = new Label("Istnieje już taka nazwa konta, spróbuj ponownie.");
         user_exist.setId("user_error");
         user_exist.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
            a_dodaj.setOnAction(e->{
                
                panel_dane.getChildren().clear();
                panel_dane.getChildren().addAll(user_add, panel_login, panel_haslo, add_user);
                panel_login.getChildren().clear();
                panel_haslo.getChildren().clear();
                panel_login.getChildren().addAll(loginLabel, loginField );
                panel_haslo.getChildren().addAll(hasloLabel, hasloField );
                
                add_user.setOnAction(w->{
                
                    Label loginWynik=new Label();
                    loginWynik.setText(loginField.getText());
                    String loginString=loginWynik.getText();
                    loginField.clear();
              
                    Label hasloWynik=new Label();
                    hasloWynik.setText(hasloField.getText());
                    String hasloString=hasloWynik.getText();
                    hasloField.clear();
                    
                    
                    panel_dane.getChildren().clear();
                    panel_dane.getChildren().addAll(user_add, panel_login, panel_haslo, add_user);
                    panel_login.getChildren().clear();
                    panel_haslo.getChildren().clear();
                    panel_login.getChildren().addAll(loginLabel, loginField );
                    panel_haslo.getChildren().addAll(hasloLabel, hasloField );
                    
                    
                    try{
             
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

                        String sql = "select login from uzytkownik where login='"+loginString+"';";
                        preparedStatement = con.prepareStatement(sql);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs != null && !rs.isClosed() && rs.next())
                        {
                            panel_dane.getChildren().add(user_exist);
                        }
                        else{
                            String sql2 = "insert into uzytkownik values ('"+loginString+"', '"+hasloString+"');";
                            Statement query = con.createStatement();
                            query.executeUpdate(sql2);
                            panel_dane.getChildren().add(user_added);
                        }
                        

                        con.close();
              
                        }
                    catch(SQLException error_polaczenie) {
                    panel_dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                    panel_dane.getChildren().add(fail);}
             
                });
                
            });
            
            
         Label user_delete = new Label("Usuń użytkownika");
         user_delete.setId("a_user");
         user_delete.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label user_deleted = new Label("Usunięto użytkownika.");
         user_deleted.setId("user_succes");
         user_deleted.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Button delete_user=new Button("Usuń");
         delete_user.setMinSize(120,30);
         delete_user.setId("log_button");
         delete_user.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
         Label user_not_exist = new Label("Nie istnieje taka nazwa konta, spróbuj ponownie.");
         user_not_exist.setId("user_error");
         user_not_exist.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        
            a_usun.setOnAction(e->{
                
                panel_dane.getChildren().clear();
                panel_dane.getChildren().addAll(user_delete, panel_login, delete_user);
                panel_login.getChildren().clear();
                panel_login.getChildren().addAll(loginLabel, loginField );
                panel_haslo.getChildren().clear();

                
                delete_user.setOnAction(w->{
                
                    Label loginWynik=new Label();
                    loginWynik.setText(loginField.getText());
                    String loginString=loginWynik.getText();
                    loginField.clear();
 
                    panel_dane.getChildren().clear();
                    panel_dane.getChildren().addAll(user_delete, panel_login, delete_user);
                    panel_login.getChildren().clear();
                    panel_login.getChildren().addAll(loginLabel, loginField );
                    panel_haslo.getChildren().clear();

                    
                    
                    try{
             
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

                        String sql = "select login from uzytkownik where login='"+loginString+"';";
                        preparedStatement = con.prepareStatement(sql);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs != null && !rs.isClosed() && rs.next())
                        {
                            
                            String sql2 = "delete from uzytkownik where login =('"+loginString+"');";
                            Statement query = con.createStatement();
                            query.executeUpdate(sql2);
                            panel_dane.getChildren().add(user_deleted);
           
                            
                        }
                        else{
                            panel_dane.getChildren().add(user_not_exist);
                            
                        }

                        con.close();
              
                        }
                    catch(SQLException error_polaczenie) {
                        panel_dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                        panel_dane.getChildren().add(fail);}
             
                });
                
            });
            
            
             
         Label user_edit = new Label("Edytuj użytkownika");
         user_edit.setId("a_user");
         user_edit.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         Label user_edited = new Label("Użytkownik edytowany.");
         user_edited.setId("user_succes");
         user_edited.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         
         Button edit_user=new Button("Edytuj");
         edit_user.setMinSize(120,30);
         edit_user.setId("log_button");
         edit_user.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm()); 
        
         
         HBox panel_login2 = new HBox();
         panel_login2.setMinWidth(200);
         panel_login2.setAlignment(Pos.CENTER_LEFT);
         panel_login2.setSpacing(15);
         panel_login2.setMinHeight(80);
         

         Label loginLabel2 = new Label("nowy login");
         loginLabel2.setId("logs");
         loginLabel2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         loginLabel2.setMinWidth(100);
         TextField loginField2 = new TextField();
         loginField2.setMinWidth(200);
         
         Label hasloLabel2 = new Label("nowe hasło");
         hasloLabel2.setId("logs");
         hasloLabel2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         hasloLabel2.setMinWidth(100);
         PasswordField hasloField2 = new PasswordField();
         hasloField2.setMinWidth(200);

         
            a_edytuj.setOnAction(e->{
                
                panel_dane.getChildren().clear();
                panel_dane.getChildren().addAll(user_edit, panel_login, panel_login2, panel_haslo, edit_user);
                panel_login.getChildren().clear();
                panel_login2.getChildren().clear();
                panel_haslo.getChildren().clear();
                
                panel_login.getChildren().addAll(loginLabel, loginField );
                panel_login2.getChildren().addAll(loginLabel2, loginField2 );
                panel_haslo.getChildren().addAll(hasloLabel2, hasloField2 );
  
                edit_user.setOnAction(w->{
                
                    Label loginWynik=new Label();
                    loginWynik.setText(loginField.getText());
                    String loginString=loginWynik.getText();
                    
                    Label loginWynik2=new Label();
                    loginWynik2.setText(loginField2.getText());
                    String loginString2=loginWynik2.getText();
                    
                    Label hasloWynik2=new Label();
                    hasloWynik2.setText(hasloField2.getText());
                    String hasloString2=hasloWynik2.getText();
                    
                    loginField.clear();
                    loginField2.clear();
                    hasloField.clear();
                    hasloField2.clear();
 
                    panel_dane.getChildren().clear();
                    panel_dane.getChildren().addAll(user_edit, panel_login, panel_login2, panel_haslo, edit_user);
                    
                    panel_login.getChildren().clear();
                    panel_login.getChildren().addAll(loginLabel, loginField );
                    
                    panel_login2.getChildren().clear();
                    panel_login2.getChildren().addAll(loginLabel2, loginField2 );
                    
                    panel_haslo.getChildren().clear();
                    panel_haslo.getChildren().addAll(hasloLabel2, hasloField2 );

                    
                    
                    try{
             
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

                        String sql = "select login from uzytkownik where login='"+loginString+"';";
                        preparedStatement = con.prepareStatement(sql);
                        ResultSet rs = preparedStatement.executeQuery();
                        if (rs != null && !rs.isClosed() && rs.next())
                        {
                            
                            String sql2 = "update uzytkownik set login='"+loginString2+"', haslo='"+hasloString2+"' where login =('"+loginString+"');";
                            Statement query = con.createStatement();
                            query.executeUpdate(sql2);
                            panel_dane.getChildren().add(user_edited);
                            
                        }
                        else{
                            panel_dane.getChildren().add(user_not_exist);
                            
                        }
                        

                        con.close();
              
                        }
                    catch(SQLException error_polaczenie) {
                        panel_dane.getChildren().add(failPolaczenie);}
                    catch(ClassNotFoundException error_sterownik) {
                        panel_dane.getChildren().add(fail);}
             
                });
                
            });
//            ScrollPane scroll = new ScrollPane();
//            scroll.setPrefSize(600,300);
//            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
//            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
//            scroll.setStyle("-fx-background-color: green;");
            
            try
        {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
        Statement zapyt = con.createStatement(); 
        String sql="select id_logs, DATEFROMPARTS(YEAR(data_logowania),MONTH(data_logowania),DAY(data_logowania)), SUBSTRING(Convert(varchar,data_logowania,100),12,12), nazwa_uzytkownika  from logs";
        ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
        ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
        ile_kolumn = wynik_kol.getColumnCount();
        zapyt.close();
        con.close();            
        }
        catch(SQLException sqle) {
            System.out.println("Błąd połączenia");}
        catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
        VBox boxes[] = new VBox[ile_kolumn]; 
        for (int i = 0; i < boxes.length; i++) 
        {
            boxes[i] = new VBox();
            boxes[i].setMinWidth(80);
        }
          Label log_read = new Label("Odczytaj logi użytkownikow");
         log_read.setId("a_user");
         log_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
        
        ////// odczyt
        
        
            a_odczyt.setOnAction(e->{
                
                panel_dane.getChildren().clear();
                panel_dane.getChildren().addAll(log_read, panel_dane_srodek);
             //   okno.getChildren().remove(scroll);
             //   okno.add(scroll, 1,2,1,1);
                
                for (int i = 0; i < boxes.length; i++) 
            {
                boxes[i].getChildren().clear();
            }
             panel_dane_srodek.getChildren().clear();
             panel_dane_srodek.getChildren().addAll(boxes);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="select id_logs, DATEFROMPARTS(YEAR(data_logowania),MONTH(data_logowania),DAY(data_logowania)), SUBSTRING(Convert(varchar,data_logowania,100),12,12), nazwa_uzytkownika  from logs";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes.length;j++)
                    {
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                 
                        boxes[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
            
            });
            
            HBox panel_tabele = new HBox();
            panel_tabele.setMinSize(600,50);
            panel_tabele.setSpacing(15);
            panel_tabele.setAlignment(Pos.CENTER);
            panel_tabele.setId("panel_tabele");
            panel_tabele.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
    
            HBox panel_tabele2 = new HBox();           
            panel_tabele2.setMinSize(600,50);
            panel_tabele2.setSpacing(15);
            panel_tabele2.setAlignment(Pos.CENTER);
            panel_tabele2.setId("panel_tabele");
            panel_tabele2.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            
            Button u_klient=new Button("Klient");
            u_klient.setMinSize(100,25);
            u_klient.setId("menu_button");
            u_klient.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            
            Button u_lekarz=new Button("Lekarz");
            u_lekarz.setMinSize(100,25);
            u_lekarz.setId("menu_button");
            u_lekarz.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            
            Button u_sprzet=new Button("Sprzet");
            u_sprzet.setMinSize(100,25);
            u_sprzet.setId("menu_button");
            u_sprzet.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            
            Button u_wizyta=new Button("Wizyta");
            u_wizyta.setMinSize(100,25);
            u_wizyta.setId("menu_button");
            u_wizyta.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            
            Button u_adres=new Button("Adres");
            u_adres.setMinSize(100,25);
            u_adres.setId("menu_button");
            u_adres.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            
            Button u_zwolnienie=new Button("Zwolnienie");
            u_zwolnienie.setMinSize(100,25);
            u_zwolnienie.setId("menu_button");
            u_zwolnienie.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            
            Button u_recepta=new Button("Recepta");
            u_recepta.setMinSize(100,25);
            u_recepta.setId("menu_button");
            u_recepta.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_skierowanie=new Button("Skierowanie");
            u_skierowanie.setMinSize(100,25);
            u_skierowanie.setId("menu_button");
            u_skierowanie.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
     
            Button u_rejestracja=new Button("Rejestracja");
            u_rejestracja.setMinSize(100,25);
            u_rejestracja.setId("menu_button");
            u_rejestracja.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
            
            
            ///////////// klient
              try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from klient";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_klient = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_klient[] = new VBox[ile_kolumn_klient]; 
            for (int i = 0; i < boxes_klient.length; i++) 
                {
                    boxes_klient[i] = new VBox();
                    boxes_klient[i].setMinWidth(80);
                }
            /////////////// lekarz
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from lekarz";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_lekarz = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_lekarz[] = new VBox[ile_kolumn_lekarz]; 
            for (int i = 0; i < boxes_lekarz.length; i++) 
                {
                    boxes_lekarz[i] = new VBox();
                    boxes_lekarz[i].setMinWidth(80);
                }
            
            /////////////////////// recepta
            
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from recepta";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_recepta = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_recepta[] = new VBox[ile_kolumn_recepta]; 
            for (int i = 0; i < boxes_recepta.length; i++) 
                {
                    boxes_recepta[i] = new VBox();
                    boxes_recepta[i].setMinWidth(80);
                }
            
            ////////////////////////////////// wizyta
            
            try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from wizyta";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_wizyta = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_wizyta[] = new VBox[ile_kolumn_wizyta]; 
            for (int i = 0; i < boxes_recepta.length; i++) 
                {
                    boxes_wizyta[i] = new VBox();
                    boxes_wizyta[i].setMinWidth(80);
                }
            
            ///////////////////////////////////////////// skierowanie
            
            
                   try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from skierowanie";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_skierowanie = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_skierowanie[] = new VBox[ile_kolumn_skierowanie]; 
            for (int i = 0; i < boxes_skierowanie.length; i++) 
                {
                    boxes_skierowanie[i] = new VBox();
                    boxes_skierowanie[i].setMinWidth(80);
                }
            ///////////////////////////////// adres
            
            
                  try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from adres";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_adres = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_adres[] = new VBox[ile_kolumn_adres]; 
            for (int i = 0; i < boxes_adres.length; i++) 
                {
                    boxes_adres[i] = new VBox();
                    boxes_adres[i].setMinWidth(80);
                }
            
            ///////////////////////// zwolnienie
            
            
                  try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from zwolnienie";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_zwolnienie = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_zwolnienie[] = new VBox[ile_kolumn_zwolnienie]; 
            for (int i = 0; i < boxes_zwolnienie.length; i++) 
                {
                    boxes_zwolnienie[i] = new VBox();
                    boxes_zwolnienie[i].setMinWidth(80);
                }
            
            
            /////////////////////////////////////// sprzet
            
                try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from sprzet";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_sprzet = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_sprzet[] = new VBox[ile_kolumn_sprzet]; 
            for (int i = 0; i < boxes_sprzet.length; i++) 
                {
                    boxes_sprzet[i] = new VBox();
                    boxes_sprzet[i].setMinWidth(50);
                }
            
            
             /////////////////////////////////////// rejestracja
            
                try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from rejestracja";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_rejestracja = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_rejestracja[] = new VBox[ile_kolumn_rejestracja]; 
            for (int i = 0; i < boxes_rejestracja.length; i++) 
                {
                    boxes_rejestracja[i] = new VBox();
                    boxes_rejestracja[i].setMinWidth(80);
                }
            
              k_tabela.setOnAction(e->{
                  
                  panel_dane_srodek.getChildren().clear();
                  panel_tabele.getChildren().clear();
                  panel_tabele2.getChildren().clear();
                  panel_dane.getChildren().clear();
                  panel_dane.getChildren().addAll(panel_tabele, panel_tabele2, panel_dane_srodek);
                  panel_tabele.getChildren().addAll(u_klient, u_lekarz, u_wizyta, u_adres, u_sprzet);
                  panel_tabele2.getChildren().addAll(u_rejestracja, u_recepta, u_zwolnienie, u_skierowanie);
                  
                  u_klient.setOnAction(klient->{
                      
                         for (int i = 0; i < boxes_klient.length; i++) 
                        {
                            boxes_klient[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_klient);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from klient";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_klient.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_klient[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                  
                  u_lekarz.setOnAction(lekarz->{
                      
                         for (int i = 0; i < boxes_lekarz.length; i++) 
                        {
                            boxes_lekarz[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_lekarz);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from lekarz";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_lekarz.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_lekarz[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                  
                  u_recepta.setOnAction(recepta->{
                      
                         for (int i = 0; i < boxes_recepta.length; i++) 
                        {
                            boxes_recepta[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_recepta);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from recepta";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_recepta.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_recepta[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                  
                  
                   u_wizyta.setOnAction(wizyta->{
                      
                         for (int i = 0; i < boxes_wizyta.length; i++) 
                        {
                            boxes_wizyta[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_wizyta);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from wizyta";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_wizyta.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_wizyta[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                   
                       u_skierowanie.setOnAction(skierowanie->{
                      
                         for (int i = 0; i < boxes_skierowanie.length; i++) 
                        {
                            boxes_skierowanie[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_skierowanie);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from skierowanie";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_recepta.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_skierowanie[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                       
                       
                       u_adres.setOnAction(adres->{
                      
                         for (int i = 0; i < boxes_adres.length; i++) 
                        {
                            boxes_adres[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_adres);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from adres";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_adres.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_adres[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                       
                        u_rejestracja.setOnAction(rejestracja->{
                      
                         for (int i = 0; i < boxes_rejestracja.length; i++) 
                        {
                            boxes_rejestracja[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_rejestracja);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from rejestracja";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_rejestracja.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_rejestracja[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                        
                             u_sprzet.setOnAction(sprzet->{
                      
                         for (int i = 0; i < boxes_sprzet.length; i++) 
                        {
                            boxes_sprzet[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_sprzet);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from sprzet";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_sprzet.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_sprzet[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                             
                             u_zwolnienie.setOnAction(zwolnienie->{
                      
                         for (int i = 0; i < boxes_zwolnienie.length; i++) 
                        {
                            boxes_zwolnienie[i].getChildren().clear();
                        }
                        panel_dane_srodek.getChildren().clear();
                        panel_dane_srodek.getChildren().addAll(boxes_zwolnienie);
                         try
                        {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                            Statement zapytanie = con.createStatement(); 
                            String sql="select * from zwolnienie";
                            ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                            while(wynik_zapytania.next())
                            {
                                int i=1,j;
                                for (j=0;j<boxes_zwolnienie.length;j++)
                                {
                                    Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                                    boxes_zwolnienie[j].getChildren().addAll(kolumna);                       
                                    i++;
                                }
                            } 
                            con.close();
                        }
                        catch(SQLException con1) {
                            System.out.println("Błąd połączenia");
                        }
                        catch(ClassNotFoundException ster1) {
                            System.out.println("Brak sterownika");
                        }
                  
                  
                  
                  });
                        

              });
              

              
         Label proc_read = new Label("Odczytaj procedurę");
         proc_read.setId("a_user");
         proc_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         
         
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql_recepta="exec proc1";
                ResultSet wynik_zapyt_recepta = zapyt.executeQuery(sql_recepta);          
                ResultSetMetaData wynik_kol_recepta = wynik_zapyt_recepta.getMetaData();
                ile_kolumn_procedura = wynik_kol_recepta.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_procedura[] = new VBox[ile_kolumn_procedura]; 
            for (int i = 0; i < boxes_procedura.length; i++) 
                {
                    boxes_procedura[i] = new VBox();
                    boxes_procedura[i].setMinWidth(50);
                }
        
              
              k_procedura.setOnAction(e->{
                  
                   panel_dane.getChildren().clear();
                   panel_dane.getChildren().addAll(proc_read, panel_dane_srodek);
             //   okno.getChildren().remove(scroll);
             //   okno.add(scroll, 1,2,1,1);
                
                for (int i = 0; i < boxes_procedura.length; i++) 
            {
                boxes_procedura[i].getChildren().clear();
            }
                panel_dane_srodek.getChildren().clear();
             panel_dane_srodek.getChildren().addAll(boxes_procedura);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="exec proc1";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes_procedura.length;j++)
                    {
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                        boxes_procedura[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
              });
              
              
                    
                Label kwer_read = new Label("Odczytaj kwerendę");
                kwer_read.setId("a_user");
                kwer_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         
         
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select klient.imie, klient.nazwisko, miasto.nazwa, adres.ulica, adres.nr_domu into #tab1 from klient join miasto on klient.id_miasto = miasto.id_miasto join adres on miasto.id_miasto=adres.id_adres; select * from #tab1;";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_kwerenda = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_kwerenda[] = new VBox[ile_kolumn_kwerenda]; 
            for (int i = 0; i < boxes_kwerenda.length; i++) 
                {
                    boxes_kwerenda[i] = new VBox();
                    boxes_kwerenda[i].setMinWidth(50);
                }
        
              
              k_kwerenda.setOnAction(e->{
                  
                   panel_dane.getChildren().clear();
                   panel_dane.getChildren().addAll(kwer_read, panel_dane_srodek);
             //   okno.getChildren().remove(scroll);
             //   okno.add(scroll, 1,2,1,1);
                
                for (int i = 0; i < boxes_kwerenda.length; i++) 
            {
                boxes_kwerenda[i].getChildren().clear();
            }
                panel_dane_srodek.getChildren().clear();
             panel_dane_srodek.getChildren().addAll(boxes_kwerenda);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="select klient.imie, klient.nazwisko, miasto.nazwa, adres.ulica, adres.nr_domu into #tab1 from klient join miasto on klient.id_miasto = miasto.id_miasto join adres on miasto.id_miasto=adres.id_adres; select * from #tab1;";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes_kwerenda.length;j++)
                    {
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                        boxes_kwerenda[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
              });
              
              
                     
                Label trigg_read = new Label("Odczytaj wynik wyzwalacza");
                trigg_read.setId("a_user");
                trigg_read.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
         
         
         
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");

        
        
                Statement zapyt = con.createStatement(); 
                String sql="select * from uzytkownicy_zmiany;";
                ResultSet wynik_zapyt = zapyt.executeQuery(sql);          
                ResultSetMetaData wynik_kol = wynik_zapyt.getMetaData();
                ile_kolumn_wyzwalacz = wynik_kol.getColumnCount();
                zapyt.close();
                con.close();            
            }
            catch(SQLException sqle) {
                System.out.println("Błąd połączenia");}
            catch(ClassNotFoundException e) {
                   System.out.println("Brak sterownika");} 
        
            VBox boxes_wyzwalacz[] = new VBox[ile_kolumn_wyzwalacz]; 
            for (int i = 0; i < boxes_wyzwalacz.length; i++) 
                {
                    boxes_wyzwalacz[i] = new VBox();
                    boxes_wyzwalacz[i].setMinWidth(80);
                }
        
              
              k_wyzwalacz.setOnAction(e->{
                  
                   panel_dane.getChildren().clear();
                   panel_dane.getChildren().addAll(trigg_read, panel_dane_srodek);
             //   okno.getChildren().remove(scroll);
             //   okno.add(scroll, 1,2,1,1);
                
                for (int i = 0; i < boxes_wyzwalacz.length; i++) 
            {
                boxes_wyzwalacz[i].getChildren().clear();
            }
                panel_dane_srodek.getChildren().clear();
             panel_dane_srodek.getChildren().addAll(boxes_wyzwalacz);
             try
            {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ApBaz;user=admin;password=qaz1234;");
                
                Statement zapytanie = con.createStatement(); 
                String sql="select * from uzytkownicy_zmiany;";
                ResultSet wynik_zapytania = zapytanie.executeQuery(sql); 
                while(wynik_zapytania.next())
                {
                    int i=1,j;
                    for (j=0;j<boxes_wyzwalacz.length;j++)
                    {
                        Label kolumna=new Label(" | "+wynik_zapytania.getString(i));                
                        boxes_wyzwalacz[j].getChildren().addAll(kolumna);                       
                        i++;
                    }
                } 
                con.close();
            }
            catch(SQLException con1) {
                System.out.println("Błąd połączenia");
            }
            catch(ClassNotFoundException ster1) {
                System.out.println("Brak sterownika");
            }   
              });
              
              
        Scene scena = new Scene(okno, 800, 600);
        
        stage.setScene(scena); 
        stage.show();
    }
    //--------------------------------------
    public static void main(String[] args) {
        launch(args);
    }  
}

