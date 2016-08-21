package marioargandona.com.petagram6.entidades;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by Robert on 7/30/2016.
 */
public class EnviarCorreo extends AsyncTask<Void , Void , Void> {

    private Context context;
    private Session session;

    private String nombre;
    private String email;
    private String mensaje;

    private ProgressDialog progressDialog;

    public EnviarCorreo(Context context , String email , String nombre , String mensaje)
    {
        this.context = context;
        this.email = email;
        this.nombre = nombre;
        this.mensaje = mensaje;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context , "Enviando correo" , "Por favor espere...", false , false);
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        Toast.makeText(context, "Correo enviado", Toast.LENGTH_LONG).show();
    }

    @Override
    protected Void doInBackground(Void... params) {
        Properties prop = new Properties();
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.socketFactory.port","587");
        prop.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.port","587");

        session = Session.getDefaultInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Config.EMAIL , Config.PASSWORD);
            }
        });


        try
        {
            MimeMessage mm = new MimeMessage(session);
            mm.setFrom(new InternetAddress(Config.EMAIL));
            mm.addRecipient(Message.RecipientType.TO , new InternetAddress(email));
            mm.setSubject(nombre);
            mm.setText(mensaje);

            Transport.send(mm);
        }
        catch(MessagingException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
