package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "marks_details")
public class MarksDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mark_id")
    private long markId;
	
	@Column(name = "subject")
    private String subject;
 
    @Column(name = "max_marks")
    private String maxMarks;
 
    @Column(name = "marks_obtained")
    private String marksObtained;
 
    @Column(name = "result")
    private String result;
    
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    
    public MarksDetail() { }
    
    public MarksDetail(String subject, String maxMarks, String marksObtained, String result) {
        this.subject = subject;
        this.maxMarks = maxMarks;
        this.marksObtained = marksObtained;
        this.result = result;
    }

	public long getMarkId() {
		return markId;
	}

	public void setMarkId(long markId) {
		this.markId = markId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMaxMarks() {
		return maxMarks;
	}

	public void setMaxMarks(String maxMarks) {
		this.maxMarks = maxMarks;
	}

	public String getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(String marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
