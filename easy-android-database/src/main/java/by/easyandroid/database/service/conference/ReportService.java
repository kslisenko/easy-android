package by.easyandroid.database.service.conference;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;

import by.easyandroid.database.service.exception.DatabaseServiceException;
import by.easyandroid.model.ApplicationInstance;
import by.easyandroid.model.conference.Category;
import by.easyandroid.model.conference.Report;
import by.easyandroid.model.conference.Reporter;
import by.easyandroid.model.conference.Section;

public class ReportService extends AbstractConferenceService<Report> {

	private static final String REPORT = "report";

	public ReportService(MongoOperations mongo) {
		super(mongo, Report.class, REPORT);
	}
	
	// TODO unit-test
	public void add(Report report, Section section, Category category, Reporter reporter, ApplicationInstance application) throws DatabaseServiceException {
		report.setSection(section);
		report.setCategory(category);
		report.setReporter(reporter);
		
		super.add(report, application);
	}

	@Override
	protected List<Report> getApplicationRelationList(ApplicationInstance application) {
		return application.getModel().getReports();
	}	
}