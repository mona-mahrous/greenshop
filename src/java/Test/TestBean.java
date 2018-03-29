/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author java-Eman
 */
//@Named("myBean")
@ManagedBean(name="myBean")
@SessionScoped
public class TestBean {
    String userName;
    String greeting;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGreeting() {
        if(userName != null) return "Welcome "+userName;
        else
            return "";
       }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    public void download(){
        ServletContext context = (ServletContext)FacesContext.getCurrentInstance(). getExternalContext().getContext();
HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance(). getExternalContext().getResponse();
response.setContentType("application/force-download");
String downloadFile ="test.txt";
response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile + "\"");
byte[] buf = new byte[1024];
try{
  String realPath = context.getRealPath("/resources/" + downloadFile);
  File file = new File(realPath);
  long length = file.length();
  BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
  ServletOutputStream out = response.getOutputStream();
  response.setContentLength((int)length);
  while ((in != null) && ((length = in.read(buf)) != -1)) {
    out.write(buf, 0, (int)length);
  }
  in.close();
  out.close();
}catch (Exception exc){
  exc.printStackTrace();
} 
    }

}
