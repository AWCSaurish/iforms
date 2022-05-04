package ebig.oracle.cloud.integration.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;


@JacksonXmlRootElement(localName = "G_1")
public class ReportServiceData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JacksonXmlProperty
	private String ACTUALTERMINATONDATE;
	@JacksonXmlProperty(localName = "CURRENTADDRESS")
	private String CURRENTADDRESS;
	@JacksonXmlProperty
	private String PERMANENTADDRESS;
	@JacksonXmlProperty
	private String CIRCLE;
	@JacksonXmlProperty
	private String CIRCLEFUNCTIONHEAD;
	@JacksonXmlProperty
	private String CIRCLEFUNCTIONHEADEMAIL;
	@JacksonXmlProperty
	private String CIRCLEFUNCTIONHEADEMPLOYEEID;
	@JacksonXmlProperty
	private String CIRCLEHEAD;
	@JacksonXmlProperty
	private String CIRCLEHEADEMAIL;
	@JacksonXmlProperty
	private String CIRCLEHEADEMPLOYEEID;
	@JacksonXmlProperty
	private String DEPARTMENTHEAD;
	@JacksonXmlProperty
	private String DEPARTMENTHEADEMAIL;
	@JacksonXmlProperty
	private String DEPARTMENTHEADEMPLOYEEID;
	@JacksonXmlProperty
	private String EMAIL;
	@JacksonXmlProperty
	private String DATEOFBIRTH;
	@JacksonXmlProperty
	private String MARITALSTATUS;
	@JacksonXmlProperty
	private String EMPLOYEEID;
	@JacksonXmlProperty
	private String FIRSTNAME;
	@JacksonXmlProperty
	private String GRADE;
	@JacksonXmlProperty
	private String JOB;
	@JacksonXmlProperty
	private String LASTNAME;
	@JacksonXmlProperty
	private String DISPLAYNAME;
	@JacksonXmlProperty
	private String LATESTSTARTDATE;
	@JacksonXmlProperty
	private String LOCATION;
	@JacksonXmlProperty
	private String MOBILEPHONE;
	@JacksonXmlProperty
	private String ORGANIZATION;
	@JacksonXmlProperty
	private String POSITIONFUNCTION;
	@JacksonXmlProperty
	private String POSITIONTITLE;
	@JacksonXmlProperty
	private String REGION;
	@JacksonXmlProperty
	private String SUBORGANIZATION;
	@JacksonXmlProperty
	private String SUPERVISOR;
	@JacksonXmlProperty
	private String SUPERVISOREMAIL;
	@JacksonXmlProperty
	private String SUPERVISOREMPLOYEEID;
	@JacksonXmlProperty
	private String WORKPHONE;
	@JacksonXmlProperty
	private String EMPLEAVEBALANCE;
	@JacksonXmlProperty
	private String ACTIVE;
	@JacksonXmlProperty
	private String CIRCLECEO;
	@JacksonXmlProperty
	private String CIRCLECEOEMAILID;
	@JacksonXmlProperty
	private String CIRCLECEOEMPLOYEEID;
	@JacksonXmlProperty
	private String NATIONALFUNCTIONHEAD;
	@JacksonXmlProperty
	private String NATIONALFUNCTIONHEADEMPLOYEEID;
	@JacksonXmlProperty
	private String NATIONALFUNCTIONHEADEMAILID;
	@JacksonXmlProperty
	private String CTO;
	@JacksonXmlProperty
	private String CTOEMPLOYEEID;
	@JacksonXmlProperty
	private String CTOEMAILID;
	@JacksonXmlProperty
	private String CXO;
	@JacksonXmlProperty
	private String CXOEMPLOYEEID;
	@JacksonXmlProperty
	private String CXOEMAILID;
	@JacksonXmlProperty
	private String CSMO;
	@JacksonXmlProperty
	private String CSMOEMPLOYEEID;
	@JacksonXmlProperty
	private String CSMOEMAILID;
	@JacksonXmlProperty
	private String CFO;
	@JacksonXmlProperty
	private String CFOEMPLOYEEID;
	@JacksonXmlProperty
	private String CFOEMAILID;
	@JacksonXmlProperty
	private String COO;
	@JacksonXmlProperty
	private String COOEMPLOYEEID;
	@JacksonXmlProperty
	private String COOEMAILID;
	
	@JsonInclude(Include.NON_NULL)
	private String message;
	
	
	
	
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getACTUALTERMINATONDATE() {
		return ACTUALTERMINATONDATE;
	}
	public void setACTUALTERMINATONDATE(String aCTUALTERMINATONDATE) {
		ACTUALTERMINATONDATE = aCTUALTERMINATONDATE;
	}
	public String getCURRENTADDRESS() {
		return CURRENTADDRESS;
	}
	public void setCURRENTADDRESS(String cURRENTADDRESS) {
		CURRENTADDRESS = cURRENTADDRESS;
	}
	public String getPERMANENTADDRESS() {
		return PERMANENTADDRESS;
	}
	public void setPERMANENTADDRESS(String pERMANENTADDRESS) {
		PERMANENTADDRESS = pERMANENTADDRESS;
	}
	public String getCIRCLE() {
		return CIRCLE;
	}
	public void setCIRCLE(String cIRCLE) {
		CIRCLE = cIRCLE;
	}
	public String getCIRCLEFUNCTIONHEAD() {
		return CIRCLEFUNCTIONHEAD;
	}
	public void setCIRCLEFUNCTIONHEAD(String cIRCLEFUNCTIONHEAD) {
		CIRCLEFUNCTIONHEAD = cIRCLEFUNCTIONHEAD;
	}
	public String getCIRCLEFUNCTIONHEADEMAIL() {
		return CIRCLEFUNCTIONHEADEMAIL;
	}
	public void setCIRCLEFUNCTIONHEADEMAIL(String cIRCLEFUNCTIONHEADEMAIL) {
		CIRCLEFUNCTIONHEADEMAIL = cIRCLEFUNCTIONHEADEMAIL;
	}
	public String getCIRCLEFUNCTIONHEADEMPLOYEEID() {
		return CIRCLEFUNCTIONHEADEMPLOYEEID;
	}
	public void setCIRCLEFUNCTIONHEADEMPLOYEEID(String cIRCLEFUNCTIONHEADEMPLOYEEID) {
		CIRCLEFUNCTIONHEADEMPLOYEEID = cIRCLEFUNCTIONHEADEMPLOYEEID;
	}
	public String getCIRCLEHEAD() {
		return CIRCLEHEAD;
	}
	public void setCIRCLEHEAD(String cIRCLEHEAD) {
		CIRCLEHEAD = cIRCLEHEAD;
	}
	public String getCIRCLEHEADEMAIL() {
		return CIRCLEHEADEMAIL;
	}
	public void setCIRCLEHEADEMAIL(String cIRCLEHEADEMAIL) {
		CIRCLEHEADEMAIL = cIRCLEHEADEMAIL;
	}
	public String getCIRCLEHEADEMPLOYEEID() {
		return CIRCLEHEADEMPLOYEEID;
	}
	public void setCIRCLEHEADEMPLOYEEID(String cIRCLEHEADEMPLOYEEID) {
		CIRCLEHEADEMPLOYEEID = cIRCLEHEADEMPLOYEEID;
	}
	public String getDEPARTMENTHEAD() {
		return DEPARTMENTHEAD;
	}
	public void setDEPARTMENTHEAD(String dEPARTMENTHEAD) {
		DEPARTMENTHEAD = dEPARTMENTHEAD;
	}
	public String getDEPARTMENTHEADEMAIL() {
		return DEPARTMENTHEADEMAIL;
	}
	public void setDEPARTMENTHEADEMAIL(String dEPARTMENTHEADEMAIL) {
		DEPARTMENTHEADEMAIL = dEPARTMENTHEADEMAIL;
	}
	public String getDEPARTMENTHEADEMPLOYEEID() {
		return DEPARTMENTHEADEMPLOYEEID;
	}
	public void setDEPARTMENTHEADEMPLOYEEID(String dEPARTMENTHEADEMPLOYEEID) {
		DEPARTMENTHEADEMPLOYEEID = dEPARTMENTHEADEMPLOYEEID;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getDATEOFBIRTH() {
		return DATEOFBIRTH;
	}
	public void setDATEOFBIRTH(String dATEOFBIRTH) {
		DATEOFBIRTH = dATEOFBIRTH;
	}
	public String getMARITALSTATUS() {
		return MARITALSTATUS;
	}
	public void setMARITALSTATUS(String mARITALSTATUS) {
		MARITALSTATUS = mARITALSTATUS;
	}
	public String getEMPLOYEEID() {
		return EMPLOYEEID;
	}
	public void setEMPLOYEEID(String eMPLOYEEID) {
		EMPLOYEEID = eMPLOYEEID;
	}
	public String getFIRSTNAME() {
		return FIRSTNAME;
	}
	public void setFIRSTNAME(String fIRSTNAME) {
		FIRSTNAME = fIRSTNAME;
	}
	public String getGRADE() {
		return GRADE;
	}
	public void setGRADE(String gRADE) {
		GRADE = gRADE;
	}
	public String getJOB() {
		return JOB;
	}
	public void setJOB(String jOB) {
		JOB = jOB;
	}
	public String getLASTNAME() {
		return LASTNAME;
	}
	public void setLASTNAME(String lASTNAME) {
		LASTNAME = lASTNAME;
	}
	public String getDISPLAYNAME() {
		return DISPLAYNAME;
	}
	public void setDISPLAYNAME(String dISPLAYNAME) {
		DISPLAYNAME = dISPLAYNAME;
	}
	public String getLATESTSTARTDATE() {
		return LATESTSTARTDATE;
	}
	public void setLATESTSTARTDATE(String lATESTSTARTDATE) {
		LATESTSTARTDATE = lATESTSTARTDATE;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String lOCATION) {
		LOCATION = lOCATION;
	}
	public String getMOBILEPHONE() {
		return MOBILEPHONE;
	}
	public void setMOBILEPHONE(String mOBILEPHONE) {
		MOBILEPHONE = mOBILEPHONE;
	}
	public String getORGANIZATION() {
		return ORGANIZATION;
	}
	public void setORGANIZATION(String oRGANIZATION) {
		ORGANIZATION = oRGANIZATION;
	}
	public String getPOSITIONFUNCTION() {
		return POSITIONFUNCTION;
	}
	public void setPOSITIONFUNCTION(String pOSITIONFUNCTION) {
		POSITIONFUNCTION = pOSITIONFUNCTION;
	}
	public String getPOSITIONTITLE() {
		return POSITIONTITLE;
	}
	public void setPOSITIONTITLE(String pOSITIONTITLE) {
		POSITIONTITLE = pOSITIONTITLE;
	}
	public String getREGION() {
		return REGION;
	}
	public void setREGION(String rEGION) {
		REGION = rEGION;
	}
	public String getSUBORGANIZATION() {
		return SUBORGANIZATION;
	}
	public void setSUBORGANIZATION(String sUBORGANIZATION) {
		SUBORGANIZATION = sUBORGANIZATION;
	}
	public String getSUPERVISOR() {
		return SUPERVISOR;
	}
	public void setSUPERVISOR(String sUPERVISOR) {
		SUPERVISOR = sUPERVISOR;
	}
	public String getSUPERVISOREMAIL() {
		return SUPERVISOREMAIL;
	}
	public void setSUPERVISOREMAIL(String sUPERVISOREMAIL) {
		SUPERVISOREMAIL = sUPERVISOREMAIL;
	}
	public String getSUPERVISOREMPLOYEEID() {
		return SUPERVISOREMPLOYEEID;
	}
	public void setSUPERVISOREMPLOYEEID(String sUPERVISOREMPLOYEEID) {
		SUPERVISOREMPLOYEEID = sUPERVISOREMPLOYEEID;
	}
	public String getWORKPHONE() {
		return WORKPHONE;
	}
	public void setWORKPHONE(String wORKPHONE) {
		WORKPHONE = wORKPHONE;
	}
	public String getEMPLEAVEBALANCE() {
		return EMPLEAVEBALANCE;
	}
	public void setEMPLEAVEBALANCE(String eMPLEAVEBALANCE) {
		EMPLEAVEBALANCE = eMPLEAVEBALANCE;
	}
	public String getACTIVE() {
		return ACTIVE;
	}
	public void setACTIVE(String aCTIVE) {
		ACTIVE = aCTIVE;
	}
	public String getCIRCLECEO() {
		return CIRCLECEO;
	}
	public void setCIRCLECEO(String cIRCLECEO) {
		CIRCLECEO = cIRCLECEO;
	}
	public String getCIRCLECEOEMAILID() {
		return CIRCLECEOEMAILID;
	}
	public void setCIRCLECEOEMAILID(String cIRCLECEOEMAILID) {
		CIRCLECEOEMAILID = cIRCLECEOEMAILID;
	}
	public String getCIRCLECEOEMPLOYEEID() {
		return CIRCLECEOEMPLOYEEID;
	}
	public void setCIRCLECEOEMPLOYEEID(String cIRCLECEOEMPLOYEEID) {
		CIRCLECEOEMPLOYEEID = cIRCLECEOEMPLOYEEID;
	}
	public String getNATIONALFUNCTIONHEAD() {
		return NATIONALFUNCTIONHEAD;
	}
	public void setNATIONALFUNCTIONHEAD(String nATIONALFUNCTIONHEAD) {
		NATIONALFUNCTIONHEAD = nATIONALFUNCTIONHEAD;
	}
	public String getNATIONALFUNCTIONHEADEMPLOYEEID() {
		return NATIONALFUNCTIONHEADEMPLOYEEID;
	}
	public void setNATIONALFUNCTIONHEADEMPLOYEEID(String nATIONALFUNCTIONHEADEMPLOYEEID) {
		NATIONALFUNCTIONHEADEMPLOYEEID = nATIONALFUNCTIONHEADEMPLOYEEID;
	}
	public String getNATIONALFUNCTIONHEADEMAILID() {
		return NATIONALFUNCTIONHEADEMAILID;
	}
	public void setNATIONALFUNCTIONHEADEMAILID(String nATIONALFUNCTIONHEADEMAILID) {
		NATIONALFUNCTIONHEADEMAILID = nATIONALFUNCTIONHEADEMAILID;
	}
	public String getCTO() {
		return CTO;
	}
	public void setCTO(String cTO) {
		CTO = cTO;
	}
	public String getCTOEMPLOYEEID() {
		return CTOEMPLOYEEID;
	}
	public void setCTOEMPLOYEEID(String cTOEMPLOYEEID) {
		CTOEMPLOYEEID = cTOEMPLOYEEID;
	}
	public String getCTOEMAILID() {
		return CTOEMAILID;
	}
	public void setCTOEMAILID(String cTOEMAILID) {
		CTOEMAILID = cTOEMAILID;
	}
	public String getCXO() {
		return CXO;
	}
	public void setCXO(String cXO) {
		CXO = cXO;
	}
	public String getCXOEMPLOYEEID() {
		return CXOEMPLOYEEID;
	}
	public void setCXOEMPLOYEEID(String cXOEMPLOYEEID) {
		CXOEMPLOYEEID = cXOEMPLOYEEID;
	}
	public String getCXOEMAILID() {
		return CXOEMAILID;
	}
	public void setCXOEMAILID(String cXOEMAILID) {
		CXOEMAILID = cXOEMAILID;
	}
	public String getCSMO() {
		return CSMO;
	}
	public void setCSMO(String cSMO) {
		CSMO = cSMO;
	}
	public String getCSMOEMPLOYEEID() {
		return CSMOEMPLOYEEID;
	}
	public void setCSMOEMPLOYEEID(String cSMOEMPLOYEEID) {
		CSMOEMPLOYEEID = cSMOEMPLOYEEID;
	}
	public String getCSMOEMAILID() {
		return CSMOEMAILID;
	}
	public void setCSMOEMAILID(String cSMOEMAILID) {
		CSMOEMAILID = cSMOEMAILID;
	}
	public String getCFO() {
		return CFO;
	}
	public void setCFO(String cFO) {
		CFO = cFO;
	}
	public String getCFOEMPLOYEEID() {
		return CFOEMPLOYEEID;
	}
	public void setCFOEMPLOYEEID(String cFOEMPLOYEEID) {
		CFOEMPLOYEEID = cFOEMPLOYEEID;
	}
	public String getCFOEMAILID() {
		return CFOEMAILID;
	}
	public void setCFOEMAILID(String cFOEMAILID) {
		CFOEMAILID = cFOEMAILID;
	}
	public String getCOO() {
		return COO;
	}
	public void setCOO(String cOO) {
		COO = cOO;
	}
	public String getCOOEMPLOYEEID() {
		return COOEMPLOYEEID;
	}
	public void setCOOEMPLOYEEID(String cOOEMPLOYEEID) {
		COOEMPLOYEEID = cOOEMPLOYEEID;
	}
	public String getCOOEMAILID() {
		return COOEMAILID;
	}
	public void setCOOEMAILID(String cOOEMAILID) {
		COOEMAILID = cOOEMAILID;
	}
	@Override
	public String toString() {
		return "ReportServiceData [ACTUALTERMINATONDATE=" + ACTUALTERMINATONDATE + ", CURRENTADDRESS=" + CURRENTADDRESS
				+ ", PERMANENTADDRESS=" + PERMANENTADDRESS + ", CIRCLE=" + CIRCLE + ", CIRCLEFUNCTIONHEAD="
				+ CIRCLEFUNCTIONHEAD + ", CIRCLEFUNCTIONHEADEMAIL=" + CIRCLEFUNCTIONHEADEMAIL
				+ ", CIRCLEFUNCTIONHEADEMPLOYEEID=" + CIRCLEFUNCTIONHEADEMPLOYEEID + ", CIRCLEHEAD=" + CIRCLEHEAD
				+ ", CIRCLEHEADEMAIL=" + CIRCLEHEADEMAIL + ", CIRCLEHEADEMPLOYEEID=" + CIRCLEHEADEMPLOYEEID
				+ ", DEPARTMENTHEAD=" + DEPARTMENTHEAD + ", DEPARTMENTHEADEMAIL=" + DEPARTMENTHEADEMAIL
				+ ", DEPARTMENTHEADEMPLOYEEID=" + DEPARTMENTHEADEMPLOYEEID + ", EMAIL=" + EMAIL + ", DATEOFBIRTH="
				+ DATEOFBIRTH + ", MARITALSTATUS=" + MARITALSTATUS + ", EMPLOYEEID=" + EMPLOYEEID + ", FIRSTNAME="
				+ FIRSTNAME + ", GRADE=" + GRADE + ", JOB=" + JOB + ", LASTNAME=" + LASTNAME + ", DISPLAYNAME="
				+ DISPLAYNAME + ", LATESTSTARTDATE=" + LATESTSTARTDATE + ", LOCATION=" + LOCATION + ", MOBILEPHONE="
				+ MOBILEPHONE + ", ORGANIZATION=" + ORGANIZATION + ", POSITIONFUNCTION=" + POSITIONFUNCTION
				+ ", POSITIONTITLE=" + POSITIONTITLE + ", REGION=" + REGION + ", SUBORGANIZATION=" + SUBORGANIZATION
				+ ", SUPERVISOR=" + SUPERVISOR + ", SUPERVISOREMAIL=" + SUPERVISOREMAIL + ", SUPERVISOREMPLOYEEID="
				+ SUPERVISOREMPLOYEEID + ", WORKPHONE=" + WORKPHONE + ", EMPLEAVEBALANCE=" + EMPLEAVEBALANCE
				+ ", ACTIVE=" + ACTIVE + ", CIRCLECEO=" + CIRCLECEO + ", CIRCLECEOEMAILID=" + CIRCLECEOEMAILID
				+ ", CIRCLECEOEMPLOYEEID=" + CIRCLECEOEMPLOYEEID + ", NATIONALFUNCTIONHEAD=" + NATIONALFUNCTIONHEAD
				+ ", NATIONALFUNCTIONHEADEMPLOYEEID=" + NATIONALFUNCTIONHEADEMPLOYEEID
				+ ", NATIONALFUNCTIONHEADEMAILID=" + NATIONALFUNCTIONHEADEMAILID + ", CTO=" + CTO + ", CTOEMPLOYEEID="
				+ CTOEMPLOYEEID + ", CTOEMAILID=" + CTOEMAILID + ", CXO=" + CXO + ", CXOEMPLOYEEID=" + CXOEMPLOYEEID
				+ ", CXOEMAILID=" + CXOEMAILID + ", CSMO=" + CSMO + ", CSMOEMPLOYEEID=" + CSMOEMPLOYEEID
				+ ", CSMOEMAILID=" + CSMOEMAILID + ", CFO=" + CFO + ", CFOEMPLOYEEID=" + CFOEMPLOYEEID + ", CFOEMAILID="
				+ CFOEMAILID + ", COO=" + COO + ", COOEMPLOYEEID=" + COOEMPLOYEEID + ", COOEMAILID=" + COOEMAILID + "]";
	}
	
	

}
