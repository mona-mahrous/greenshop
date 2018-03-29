/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Test;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author java-Eman
 */
//@Named("myBean")
@ManagedBean(name="listBean")
@ApplicationScoped
public class ListArrayBean {

    public ListArrayBean() {
        categoryList = new Category[6];
		categoryList[0] = new Category("Clothing", "Cat1",0);
		categoryList[1] = new Category("Decorating", "Cat2",0);
		categoryList[2] = new Category("Garden", "Cat3",0);
                categoryList[3] = new Category("Homeware", "Cat4",0);
		categoryList[4] = new Category("Incense and candles", "Cat5",0);
		categoryList[5] = new Category("Toys and Games", "Cat6",0);
    }
    
    Category[] categoryList;



	public Category[] getCategoryList() {

		return categoryList;
	}
public void incrementCategory(String name)
{
    for (int i=0; i<categoryList.length;i++)
    {
        Category v= categoryList[i];
        System.out.println("come:"+name+" here"+v.getCategoryValue());
        if(v.getCategoryValue().equalsIgnoreCase(name)){
            System.out.print("true");
           v.setCategoryVotes(v.getCategoryVotes()+1);
           categoryList[i]=v;
            break;
        }
        
    }

        
    
}
// inner class for the list
    public static class Category{
		public String categoryLabel;
		public String categoryValue;
                public int categoryVotes;

        public int getCategoryVotes() {
            return categoryVotes;
        }

        public void setCategoryVotes(int categoryVotes) {
            this.categoryVotes = categoryVotes;
        }

		public Category(String categoryLabel, String categoryValue,int categoryVotes){
			this.categoryLabel = categoryLabel;
			this.categoryValue = categoryValue;
                        this.categoryVotes=categoryVotes;
		}

		public String getCategoryLabel(){
			return categoryLabel;
		}

		public String getCategoryValue(){
			return categoryValue;
		}
	}
}
