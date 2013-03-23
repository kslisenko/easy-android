package by.easyandroid.webapp.form.appCustomization.reporter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import by.easyandroid.model.conference.Reporter;
import by.easyandroid.webapp.form.AbstractEntityDialog;

@ManagedBean
@SessionScoped
public class EditReporterDialog extends AbstractEntityDialog<Reporter> {

	public EditReporterDialog() throws InstantiationException, IllegalAccessException {
		super(Reporter.class);
	}
}