import java.io.File;
import java.io.Serializable;
import java.util.Date;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.StreamBuilder;

public class SampleStudentBeanIOLoader {

	static final char FIELD_DELIM = ',';
	static final String inputFile = "student.unl";

	/*- student.unl
	 * 1,Sandra,05011979
	2,John Doe,12202004
	3,Joseph Hoover,01312009
	 */
	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		StreamFactory factory = StreamFactory.newInstance();
		StreamBuilder builder = new StreamBuilder("studentFile").format("delimited")
				.parser(new DelimitedParserBuilder(FIELD_DELIM)).addRecord(SampleStudent.class);

		factory.define(builder);
		BeanReader in = factory.createReader("studentFile", new File(inputFile));
		try {
			SampleStudent student = null;
			while ((student = (SampleStudent) in.read()) != null) {
				System.out.println(student);
			}
		} finally {
			in.close();
		}
		System.out.println("Done!!!");
	}
}

@Record(minOccurs = 1)
class Student implements Serializable {

	private static final long serialVersionUID = 1552912864129373786L;

	@Field(at = 0)
	private int studentId;

	@Field(at = 1)
	private String name;

	@Field(at = 2, format = "MMddyyyy")
	private Date dob;

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *            the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob
	 *            the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", dob=" + dob + "]";
	}
}
-----------------------
