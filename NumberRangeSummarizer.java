import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import javax.swing.JOptionPane;

public interface NumberRangeSummarizer {
    List<Integer> group = new ArrayList<>();
    List<String> stringOutput = new ArrayList<>();
    
    public static List<String> summarizedString(Integer[] index){
        int minVal = 0;
        int maxVal = 0;
        int lastMinVal = 0;
        int lastMaxVal = 0;
        int val = 0;
        List<Integer> numbers = Arrays.asList(index);

        Collections.sort(numbers);
        int num =  numbers.get(0) - 0;

        for(int i=0; i < index.length;i++){
            val = numbers.get(i) - i;

            if(val==num){
                group.add(numbers.get(i));
                num = val;
            }
            else{
                //System.out.println("Min: " + group.get(0));
                minVal = group.get(0);
                //System.out.println("Max: " + group.get(group.size() - 1));
                maxVal = group.get(group.size() - 1);
                if(minVal==maxVal){
                    stringOutput.add(minVal + "");
                }else{
                    stringOutput.add(minVal + "-" + maxVal);
                }
                num = val;
                group.clear();
                group.add(numbers.get(i));
            }
        }

        lastMinVal = group.get(0);
        lastMaxVal = group.get(group.size() - 1);

        if(lastMinVal==lastMaxVal){
            stringOutput.add("" + lastMinVal);
        }else{
            stringOutput.add(lastMinVal + "-" + lastMaxVal);
        }
        
        List<String> group = new ArrayList<>();
        return group;
    }

    public static void main(String[] args) {
        Integer[] index = {1,3,6,7,8,12,13,14,15,21,22,23,24,31};
        summarizedString(index);
        JOptionPane.showMessageDialog(null, stringOutput);
    }
}
