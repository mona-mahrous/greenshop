/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author java-Eman
 */
//@Named("myBean")
@ManagedBean(name = "voteBean")
@SessionScoped
public class VoteBack {

    @ManagedProperty(value = "#{listBean}")
    ListArrayBean listBean;

    public ListArrayBean getListBean() {
        return listBean;
    }

    public void setListBean(ListArrayBean listBean) {
        this.listBean = listBean;
    }
    boolean voted;

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public boolean isVoted() {
        return voted;
    }
    String choosen; // look for it again

    public String getChoosen() {
        return choosen;
    }

    public void setChoosen(String choosen) {
        this.choosen = choosen;
    }

    public String voteButtonBack() {
        if (getChoosen() != null) {
            listBean.incrementCategory(getChoosen());
            setVoted(true);
            return "Results";
        } else {
            return null;
        }
    }
}
