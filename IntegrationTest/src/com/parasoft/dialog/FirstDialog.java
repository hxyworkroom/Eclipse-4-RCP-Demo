package com.parasoft.dialog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FirstDialog  extends  Dialog {
		protected  Shell shell;  
		private   int  result;
		public  FirstDialog(Shell parent,  int  style)  {
			super (parent, style);
		} 

		public  FirstDialog(Shell parent)  {
			this (parent, SWT.NONE);
		} 

		public   int  open()  {
			createContents();
			shell.open();
			shell.layout();
			Display display  =  getParent().getDisplay();
			while  ( ! shell.isDisposed())  {
				if  ( ! display.readAndDispatch())
					display.sleep();
			} 
			return  result;
		} 

		protected   void  createContents()  {
			shell  =   new  Shell(getParent(), SWT.DIALOG_TRIM  |  SWT.APPLICATION_MODAL);
			shell.setSize(300,200);
			shell.setText( " µÚÒ»¸ö¶Ô»°¿ò " );
	        //¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª·Ö¸îÏß¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª

			final  Button okButton  =   new  Button(shell, SWT.NONE);
			okButton.addSelectionListener( new  SelectionAdapter()  {
				public   void  widgetSelected(SelectionEvent e)  {
					result  =   1 ;
					System.out.println("~~µã»÷ok~~");
					shell.dispose();
				} 
			});
			okButton.setText( " OK " );
			okButton.setBounds(30,60,60,30);
	        //¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª·Ö¸îÏß¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª¡ª

			final  Button cancelButton  =   new  Button(shell, SWT.NONE);
			cancelButton.addSelectionListener( new  SelectionAdapter()  {
				public   void  widgetSelected(SelectionEvent e)  {
					result  =   2 ;
					System.out.println("~~µã»÷cancel~~");
					shell.dispose();
				} 
			});
			cancelButton.setText( " Cancel " );
			cancelButton.setBounds(150,60,60,30);
	}
}




