package com.lottery.sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/29 15:02
 * 抽奖系统
 */
public class LotterySys extends JFrame {
    //定义常量,写这个时,发现全局变量的好处!
    private String LEVELNUM;
    private int NUMBER = 0;
    private int LUNSHU = 1;
    private int LUNSHUF = 0;
    private int PAGENUM = 5;
    private int[] indexs = new int[PAGENUM];
    private boolean stop = true;
    File file2 = new File(PATH+"\\"+"luckyperson.txt");
    //定义面板
    private JFrame frame = new JFrame("cell技术部门年会抽奖");
    Container contentPanel = frame.getContentPane();
    private JPanel panelButton = new JPanel();
    private JPanel panelText = new JPanel();
    private JPanel panelTop = new JPanel();
    private final JTextArea luckyPerson = new JTextArea(PAGENUM, 1);
    private JTextField level = new JTextField("请输入几等奖：");
    private JTextField number = new JTextField("请输入名额：");
    private JButton start = new JButton("开始抽奖");
    private JButton end = new JButton("停止抽奖");
    private JLabel title = new JLabel("2019年全民生活APP项目组年会欢迎您");
    private JLabel levelJiangping = new JLabel("祝你中奖");
    private ArrayList<String> nameList = new ArrayList<String>();
    private ArrayList<String> luckyList = new ArrayList<String>();
    private static final String PATH = "D:\\idea\\ideaSpace_dynamicDbbank\\dbank\\dbank-pusher\\src\\main\\resources\\data";
    Thread thread = new RandomThread();

    //线程循环显示
    class RandomThread extends Thread {
        @Override
        public void run() {
            stop = true;//此处该如何终止线程呐,不是很懂,就用了一个boolean型的全局变量,在点击停止抽奖时//給stop赋值false,从而停止循环显示.
            while (stop) {
                luckyPerson.setText("");
                random();
                for (int i = 0; i < PAGENUM; i++) {
                    String line = (String) nameList.get(indexs[i]);
                    luckyPerson.append(i + line + "\n");
                }
                try {
                    sleep(100);//有个问题,和下面的语句调换位置,显示的就有问题!!!
                    luckyPerson.paintImmediately(luckyPerson.getBounds());
                } catch (Exception eee) {
                }
            }
        }
    }

    //level监空
    class LevelEvent extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == '\n') {

                String numberStr = level.getText();
                try {
                    int levelNum = Integer.parseInt(numberStr);
                    switch (levelNum) {
                        case 1:
                            LEVELNUM = "一等";
                            break;
                        case 2:
                            LEVELNUM = "二等";
                            break;
                        case 3:
                            LEVELNUM = "三等";
                            break;
                        default:
                            LEVELNUM = "普通";
                            break;
                    }
                    level.setText(levelNum + "----------");
                    level.selectAll();
                } catch (Exception ee) {
                    LEVELNUM = numberStr;
                }
            }
        }
    }

    //number监听:输入的值
    class NumberEvent extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
            if (e.getKeyChar() == '\n') {
                String numberStr = number.getText();
                PAGENUM = 5;
                try {
                    NUMBER = Integer.parseInt(numberStr);
                    if ((NUMBER % PAGENUM) == 0) {
                        LUNSHU = NUMBER / PAGENUM;
                    } else {
                        LUNSHU = NUMBER / PAGENUM + 1;
                    }
                    LUNSHUF = 0;
                    indexs = new int[PAGENUM];
                    number.setText(NUMBER + "----------");
                    number.selectAll();
                } catch (Exception ee) {
                    number.setText("请输入罗马数字");
                }

            }
        }
    }

    //stop并保存
    class EndEvent extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            stop = false;
            levelJiangping.setText("恭喜以下同事 获得" + LEVELNUM + "奖");
            String strs = luckyPerson.getText();
            String[] person = strs.split("\n{1,}");
            try {
                BufferedWriter out = new BufferedWriter(new FileWriter(file2, true));
                for (String str : person) {
                    out.write(LEVELNUM + "  " + "第" + LUNSHUF + "轮:   " + str + "\n");
                    out.newLine();
                }
                luckyList.clear();
                for (int i : indexs) {
                    luckyList.add(nameList.get(i));
                }
                nameList.removeAll(luckyList);
                out.close();
            } catch (Exception eee) {
                System.out.println("out **");
            }

        }
    }

    //开始按钮，用来循环显示名单
    class StartEvent extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            LUNSHUF = LUNSHUF + 1;
            if (LUNSHUF > LUNSHU) {
                levelJiangping.setText("超过名额已满");
                return;
            } else if (LUNSHUF == LUNSHU) {
                PAGENUM = NUMBER % PAGENUM == 0 ? PAGENUM : NUMBER % PAGENUM;
            }
            levelJiangping.setText(LEVELNUM + "奖:共" + NUMBER + "名。 共" + LUNSHU + "轮,第" + LUNSHUF + "轮");
            new RandomThread().start();
        }
    }

    void random() {
        for (int i = 0; i < PAGENUM; ) {
            boolean allTrue = true;
            int index = (int) (Math.random() * (nameList.size()));
            for (int j = 0; j < i; j++) {
                if (index == indexs[j]) {
                    allTrue = !allTrue;
                }
            }
            if (allTrue) {
                indexs[i] = index;
                i++;
            }
        }
    }

    //子类结束
    //构造器
    public LotterySys() {
        this.initFrame();
        this.importName();
        level.addKeyListener(new LevelEvent());
        number.addKeyListener(new NumberEvent());
        start.addMouseListener(new StartEvent());
        end.addMouseListener(new EndEvent());
    }

    //设置面板样式
    void initFrame() {
        //1  主面板
        panelTop.add(title);
        panelTop.setBackground(Color.yellow);
        title.setForeground(Color.red);
        title.setFont(new Font("楷体", Font.BOLD, 40));
        contentPanel.add(panelTop, BorderLayout.NORTH);

        //2 滚动显示面板
        //panelText.setLayout(null);
        panelText.add(levelJiangping, BorderLayout.NORTH);
        levelJiangping.setForeground(Color.magenta);
        levelJiangping.setFont(new Font("黑体", Font.BOLD, 36));
        panelText.add(luckyPerson, BorderLayout.CENTER);
        panelText.setBackground(Color.pink);
        contentPanel.add(panelText, BorderLayout.CENTER);

        //文本框
        level.setBackground(Color.CYAN);
        //level.setBounds(80,30,80,30);
        level.selectAll();
        number.setBackground(Color.pink);
        //number.setBounds(80,30,80,30);
        number.setForeground(Color.red);
        number.selectAll();

        luckyPerson.setBackground(Color.pink);
        luckyPerson.setForeground(Color.red);
        luckyPerson.setFont(new Font("黑体", Font.BOLD, 30));
        //3 按钮面板
        panelButton.add(start);
        panelButton.add(end);
        panelButton.add(level, BorderLayout.EAST);
        panelButton.add(number, BorderLayout.EAST);
        panelButton.setBackground(Color.blue);
        contentPanel.add(panelButton, BorderLayout.SOUTH);
        frame.pack();

        frame.setVisible(true);
    }

    //设置文件导入
    void importName() {
        try {
            String line;
            File file = new File(PATH+"\\"+"empList_" +"20191129.txt");
            BufferedReader in = new BufferedReader(new FileReader(file));
            while ((line = in.readLine()) != null) {
                nameList.add(line);
            }
            in.close();
        } catch (Exception ee) {
            System.out.println("找不到文件");
        }
    }

    public static void main(String[] args) {
        new LotterySys();
    }
}
