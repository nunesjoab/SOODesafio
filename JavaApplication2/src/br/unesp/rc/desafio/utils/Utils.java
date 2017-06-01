/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesp.rc.desafio.utils;

import br.unesp.rc.desafio.visao.ManagerGUI;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Phones
 */
public class Utils {
    public static void createPie(DefaultPieDataset pieDataset){
        
       
        JFreeChart chart = ChartFactory.createPieChart("Grafico Torta",pieDataset,true,true,true);
        PiePlot p=(PiePlot)chart.getPlot();
        ChartFrame frame =new ChartFrame("Grafico Torta",chart);
       
        frame.setVisible(true);
        frame.setSize(450,500);
         ManagerGUI.centralizar(frame);
        
         
        
    }
    public static void createBar(DefaultCategoryDataset dataset){
       JFreeChart chart =ChartFactory.createBarChart("Grafico"," ", " ", dataset);
       CategoryPlot p=chart.getCategoryPlot();
       p.setRangeGridlinePaint(Color.black);
       ChartFrame frame=new ChartFrame("Grafico de BArras",chart);
       frame.setVisible(true);
       //frame.setSize(400,350);
       ManagerGUI.centralizar(frame);
       
    }
    public static void createLine(DefaultCategoryDataset dataset){
       JFreeChart chart =ChartFactory.createLineChart("Grafico"," ", " ", dataset);
       CategoryPlot p=chart.getCategoryPlot();
       p.setRangeGridlinePaint(Color.black);
       ChartFrame frame=new ChartFrame("Grafico de BArras",chart);
       frame.setVisible(true);
       frame.setSize(400,350);
       ManagerGUI.centralizar(frame);
       
    }
}
       
