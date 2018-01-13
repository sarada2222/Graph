package graph2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_view extends Frame implements ActionListener,WindowListener{
	
	private Button button1 = new Button("BarChart");
	private Button button2 = new Button("LineChart");
	public static int a = 0;
	
	public Graph_view() {
		
		addWindowListener(this);
		setTitle("Graph");
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		
		int ton;//id;
		String name,year;
		ResultSet rs;
		
		MYSQL mysql = new MYSQL();
		
		rs = mysql.selectAll();
		
		
		try {
			while (rs.next()) {
				//id = rs.getInt("id");
				name = rs.getString("name");
				year = rs.getString("year");
				ton = rs.getInt("ton");
				data.addValue(ton,name,year);
			} 
		} catch (Exception e) {
			// TODO: handle exception
    		e.printStackTrace();
		}
		
		/*data.addValue(300, "USA","2005");
		data.addValue(500, "USA","2006");
		data.addValue(120, "USA","2007");
		
		data.addValue(200, "China","2005");
		data.addValue(400, "China","2006");
		data.addValue(320, "China","2007");*/
		
				if(this.a == 0) {
					JFreeChart chart = ChartFactory.createLineChart(
					"Import Volume",
					"Year",
					"Ton",
					data, 
					PlotOrientation.VERTICAL,
					true,
					false,
					false);
					ChartPanel cpanel = new ChartPanel(chart);
					add(cpanel,BorderLayout.CENTER);
				}else{
					JFreeChart chart = ChartFactory.createBarChart(
							"Import Volume",
							"Year",
							"Ton",
							data, 
							PlotOrientation.VERTICAL,
							true,
							false,
							false);
					ChartPanel cpanel = new ChartPanel(chart);
					add(cpanel,BorderLayout.CENTER);
				}
		
		setLayout(new FlowLayout(FlowLayout.CENTER));	
		add(button1);
		button1.addActionListener(this);
		add(button2);
		button2.addActionListener(this);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button1) {
			dispose();
			this.a = 1;
			Graph_view graph = new Graph_view();
			graph.setBounds(5,5,755,555);
			graph.setVisible(true);
		}else if(e.getSource() == button2) {
			dispose();
			this.a = 0;
			Graph_view graph = new Graph_view();
			graph.setBounds(5,5,755,555);
			graph.setVisible(true);
		}
		
	}

}