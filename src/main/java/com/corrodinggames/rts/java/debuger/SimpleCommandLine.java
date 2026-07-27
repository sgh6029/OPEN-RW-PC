package com.corrodinggames.rts.java.debuger;

import javax.swing.*;

import org.lwjgl.opengl.Display;

import com.corrodinggames.rts.gameFramework.GameEngine;
import com.corrodinggames.rts.gameFramework.j.NetworkConnection;

import java.awt.*;

public class SimpleCommandLine extends JFrame {
    public JTextArea textArea;
    private JTextField inputField;
    private JCheckBox topCheckBox;
    
    public SimpleCommandLine() {
        // 设置窗口
        setTitle("命令行窗口");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        
        // 创建组件
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        textArea.setFont(new Font("宋体", Font.PLAIN, 14));
        
        inputField = new JTextField();
        topCheckBox = new JCheckBox("窗口置顶");
        
        // 布局
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JLabel("> "), BorderLayout.WEST);
        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(topCheckBox, BorderLayout.EAST);
        
        add(bottomPanel, BorderLayout.SOUTH);
        
        // 事件处理
        inputField.addActionListener(e -> processCommand());
        topCheckBox.addActionListener(e -> setAlwaysOnTop(topCheckBox.isSelected()));
        
        // 初始信息
        textArea.append("欢迎使用命令行窗口！输入 'hello' 测试，输入 'help' 查看帮助\n> ");
    }
    
    private void processCommand() {
        String cmd = inputField.getText().trim();
        inputField.setText("");
        
        if (!cmd.isEmpty()) {
            textArea.append(cmd + "\n");
            
            String response = switch (cmd.toLowerCase()) {
                case "hi" -> {
                    for(NetworkConnection conn:GameEngine.getInstance().networkEngine.aM){
                        textArea.append("player: "+conn.z.v);
                    }
                    yield "finish";
                }
                case "hwi" -> {
                    yield "finish";
                }
                case "clear" -> {
                    textArea.setText("");
                    yield "屏幕已清空";
                }
                case "exit" -> {
                    System.exit(0);
                    yield "";
                }
                default -> "未知命令: " + cmd;
            };
            
            textArea.append(response + "\n> ");
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
    
    public static void main(String[] args) {
        // 直接创建窗口，不使用复杂的LookAndFeel设置
        SwingUtilities.invokeLater(() -> {
            new SimpleCommandLine().setVisible(true);
        });
    }
}