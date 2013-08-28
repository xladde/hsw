import java.util.ArrayList;

public class MailList
{
    private ArrayList<Email> mList;
    
    public MailList(){
        mList = new ArrayList<Email>();
    }
    
    public void speichereEmail(Email e){
        mList.add(e);
    }
    
    public void entferneEmail(int index){
        mList.remove(index);
    }
    
    public int anzahlAdressen(){
        return mList.size();
    }
    
    public void printEmail(int index){
        if(index < anzahlAdressen()){
            System.out.println(mList.get(index).toString());
        }
    }
    
}