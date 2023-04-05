/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jTable;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author icedo
 */
public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {
    
    private JDateChooser datechooser;
    private Date date;
    
    public DateCellEditor() {
        datechooser = new JDateChooser();
        datechooser.setDateFormatString("dd/MM/yyyy");
        
        datechooser.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    stopCellEditing();
                }
            }
        });
    }
    
    @Override
    public Object getCellEditorValue() {
        return date;
    }

   @Override
public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    date = (Date) value;
    if (date == null) {
        date = new Date();
    }
    datechooser.setDate(date);
    return datechooser;
}
    
}







