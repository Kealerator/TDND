/*------------------------------------------------------------------------------------------------
 * 
 * Scribe is ment for different kind of logs, errors, successess, anything.
 * Scribe as it's name says, will write everything down to ArrayList with a timestamp.
 * 
 *------------------------------------------------------------------------------------------------ 
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Scribe {

    private ArrayList<String> log;
    private boolean warningTag;

    public Scribe() {
        this.log = new ArrayList<>();
        this.warningTag = false;
    }

    public void add(String entry) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd. HH:mm:ss").format(new java.util.Date());
        this.log.add(timestamp + " ::: " + entry);
    }

    public void add(String entry, boolean warningTag) {
        if (warningTag) {            
            entry += " <======= WARNING";
            this.add(entry); 
        }else{
            this.add(entry);
        }
    }

    public void print() {
        String line = "";

        for (String entry : this.log) {
            line += entry + "\n";
        }
        System.out.println(line);
    }
}
