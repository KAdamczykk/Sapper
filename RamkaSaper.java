import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RamkaSaper extends JFrame  {
    private int max_bomb = 10;
    private int iloscBomb = 10;
    public RamkaSaper(){
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setTitle("Saper");
        this.setLayout(new GridLayout(9,9,0,0));
        this.dodajButtony();
        this.setLocation(450,150);
        this.pack();



    }
    private void dodajButtony(){

        JButton[][] buttons = new JButton[8][8];
        for (int i =0; i<8; i++){
            for (int j = 0; j<8; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(75,50));
                buttons[i][j] = button;
            }
        }
        List<List<Integer>> randoms = losujPola();

        buttons = rozpakujBomby(randoms, buttons);
        buttons = uzupelnijInfo(buttons);
        buttons = UkryjTekst(buttons);
        buttons = dodajAkcje(buttons);

        this.dodajButtonyDoPlanszy(buttons);



    }
    private List<List<Integer>> losujPola(){
        List<List<Integer>> randoms = new ArrayList<>();
        Random random = new Random();
        int x,y;

        while (max_bomb >0){
            x = random.nextInt(0,8);
            y = random.nextInt(0,8);
            List<Integer> var = new ArrayList<>();
            var.add(x);
            var.add(y);
            if (!randoms.contains(var)){
                randoms.add(var);
                max_bomb--;
            }

        }
        return randoms;
    }
    private JButton[][] rozpakujBomby(List<List<Integer>> randoms, JButton[][] buttons){
        int x,y;

        JButton button;
        while (!randoms.isEmpty()){
            List<Integer> var = randoms.get(0);
            x = var.get(0);
            y = var.get(1);
            button = buttons[x][y];
            button.setText("*");
            randoms.remove(0);
        }
        return buttons;
    }
    private void dodajButtonyDoPlanszy(JButton[][] buttons){
        JButton button;
        for (int i = 0; i < 8; i++){
            for (int j = 0; j<8; j++){
                button = buttons[i][j];
                this.add(button);
            }
        }
    }
    private JButton[][] uzupelnijInfo(JButton[][] button){
        for (int i =0; i<8;i++){
            for (int j = 0; j<8;j++) {
                int counter = 0;
                if (button[i][j].getText().equals("*")) {
                    continue;
                }
                if (i == 0) {
                    if (j == 0) {
                        if (button[i][j + 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i+1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i+1][j+1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText(""+counter);

                    } else if (j==7) {
                        if (button[i][j -1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i+1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i+1][j-1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText(""+counter);

                    } else {
                        if (button[i][j + 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i+1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i][j - 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i+1][j-1].getText().equals("*")){
                            counter++;
                        }
                        if (button[i+1][j+1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText("" + counter);

                    }
                } else if (i == 7) {
                    if (j == 0) {
                        if (button[i][j + 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i-1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j+1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText(""+counter);

                    } else if (j==7) {
                        if (button[i][j -1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i-1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j-1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText(""+counter);

                    } else {
                        if (button[i][j + 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i-1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i][j - 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i-1][j-1].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j+1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText("" + counter);

                    }

                } else {
                    if (j == 0) {
                        if (button[i][j + 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i+1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i+1][j+1].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j+1].getText().equals("*")){
                            counter++;
                        }

                        button[i][j].setText(""+counter);

                    } else if (j==7) {
                        if (button[i][j -1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i+1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i+1][j-1].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j-1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText(""+counter);

                    } else {
                        if (button[i][j + 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i+1][j].getText().equals("*")){
                            counter++;
                        }
                        if (button[i][j - 1].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i-1][j].getText().equals("*")) {
                            counter++;
                        }
                        if (button[i-1][j+1].getText().equals("*")){
                            counter++;
                        }
                        if (button[i-1][j-1].getText().equals("*")){
                            counter++;
                        }
                        if (button[i+1][j-1].getText().equals("*")){
                            counter++;
                        }
                        if (button[i+1][j+1].getText().equals("*")){
                            counter++;
                        }
                        button[i][j].setText("" + counter);

                    }
                }

            }
        }
        return button;
    }
    private JButton[][] dodajAkcje(JButton[][] buttons){
        for (int i = 0; i < 8; i++){
            for (int j = 0 ; j < 8; j++){
                    JButton button = buttons[i][j];
                    button.addActionListener(e -> {
                        button.setEnabled(false);
                        button.setText((String) button.getClientProperty("originalText"));
                        if (button.getText().equals("*")){
                            setEnabled(false);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException ex) {
                                System.out.println();
                            }
                            this.dispose();
                            new RamkaSaper();
                        }


                    });
                    buttons[i][j] = button;
                }
            }

        return buttons;
    }
    private JButton[][] UkryjTekst(JButton[][] buttons){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].putClientProperty("originalText", buttons[i][j].getText());
                buttons[i][j].setText("");
            }
        }

        return buttons;
    }



}
