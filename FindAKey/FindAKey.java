import java.util.*;
import java.awt.*;
import java.util.List;
public class FindAKey
{
    
    private static HashMap<String, Integer> noteMap = new HashMap<>();
    
    private static String[] notes = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
    
    private static String[] majorScale = {"w", "w", "h", "w", "w", "w", "h"};
    
    private static String[] majorMods = {"", "m", "m", "", "(7 or major)", "m", "dim"};
    
    private static String[] scales = {"ionian", "dorian", "phrygian", "lydian", "mixolydian", "aeolian", "locrian"};
    
    private static String[] stepMap = {"w", "h"};
    
    private static HashMap<String, Integer> scaleMap = new HashMap<>();
    
    private static String getOver(Integer i, String[] arr) // i, the index possibly out of the array length to return; arr, the array to return the index from
    {
        int index = i;
        while(index >= arr.length)
        {
            index -= arr.length;
        }
        return arr[index];
    }
    
    private static boolean arrHas(String v, String[] arr) // v, the value to check for; arr, the array to check for the value in
    {
        boolean result = false;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i].equals(v))
            {
                result = true;
            }
        }
        return result;
    }
    
    private static List<String> getChords(String note, String scale)
    {
        List<String> result = new ArrayList<String>();
        
        int stepStart = -1;
        String tempScale = new String(scale);
        for(int i = 0; i < scales.length; i++)
        {
            if(scales[i].equals(tempScale))
            {
                stepStart = i;
            }
        }
        int stepIndex = stepStart;
        
        int noteIndex = -1;
        String tempNote = new String(note);
        for(int i = 0; i < notes.length; i++)
        {
            if(notes[i].equals(tempNote))
            {
                noteIndex = i;
            }
        }
        
        int step = 0;
        String currNote = "";
        String mod = "";
        
        for(int j = 0; j <= 6; j++)
        {
            currNote = getOver(noteIndex, notes);
            mod = getOver(stepIndex, majorMods);
            result.add(currNote + mod);
            
            for(int i = 0; i < stepMap.length; i++)
            {
                if(stepMap[i].equals(getOver(stepIndex, majorScale)))
                {
                    step = i + 1;
                }
            }
            
            stepIndex += 1;
            noteIndex += step;
            
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        String input = "";
        String note = "";
        String scale = "";
        
        while(!input.equals("quit"))
        {
            while(!(arrHas(input, notes) || input.equals("quit")))
            {
                System.out.println("Enter root note:");
                input = inputScanner.nextLine();
                if(input.equals("Bb")){
                    input = "A#";
                }
                if(input.equals("Db")){
                    input = "C#";
                }
                if(input.equals("Eb")){
                    input = "D#";
                }
                if(input.equals("Gb")){
                    input = "A#";
                }
                if(input.equals("Ab")){
                    input = "G#";
                }
                if(!(arrHas(input, notes) || input.equals("quit")))
                {
                    System.out.println("Invalid note. Please enter a note with the following format: 'A', 'Bb', 'A#'.");
                }
            }
            if(input.equals("quit"))
            {
                System.out.println("Quitting!");
                System.exit(0);
            }
            note = input;
            while(!(arrHas(input, scales) || input.equals("quit")))
            {
                System.out.println("Enter scale type:");
                input = inputScanner.nextLine();
                if(input.equals("major")){
                    input = "ionian";
                }
                if(input.equals("minor")){
                    input = "aeolian";
                }
                if(!(arrHas(input, scales) || input.equals("quit")))
                {
                    System.out.println("Invalid scale type. Please enter a type with the following format: 'major', 'minor', 'ionian'.");
                }
            }
            if(input.equals("quit"))
            {
                System.out.println("Quitting!");
                System.exit(0);
            }
            scale = input;
            System.out.println("Scale: " + getChords(note, scale).toString());
            System.out.println("============");
        }
    }
    
    
}
