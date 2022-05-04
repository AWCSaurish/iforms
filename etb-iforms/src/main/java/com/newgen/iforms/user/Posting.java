package com.newgen.iforms.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.awcsoftware.dao.IGmmcoMdmDao;
import com.newgen.dto.ITGLSetBean;
import com.newgen.dto.MiroBean;
import com.newgen.dto.MiroPostingHeaderBean;
import com.newgen.dto.MiroPostingItemSetBean;
import com.newgen.dto.WTaxSetBean;
import com.newgen.iforms.EControl;
import com.newgen.iforms.FormDef;
import com.newgen.iforms.custom.IFormReference;
import com.newgen.iforms.custom.IFormServerEventHandler;
import com.newgen.methods.General;
import com.newgen.methods.MiroRelated;
import com.newgen.mvcbeans.model.WorkdeskModel;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Posting implements IFormServerEventHandler {
	@Autowired
	private IGmmcoMdmDao dao;
	final static Logger logger = Logger.getLogger(Posting.class);

	public Posting() {
		logger.info("Posting Constructor !!");
	}

	String Query = null, Query1 = null;

	List<List<String>> result = null, result1 = null;

	@Override
	public void beforeFormLoad(FormDef fd, IFormReference ifr) {
		ifr.clearCombo("user_action");
		ifr.addItemInCombo("user_action", "Approved", "Approved");
		// ifr.addItemInCombo("user_action", "Raise Exceptions", "Raise Exceptions");
		ifr.addItemInCombo("user_action", "Reject", "Reject");

	}

	@Override
	public String executeCustomService(FormDef arg0, IFormReference arg1, String arg2, String arg3, String arg4) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

	@Override
	public JSONArray executeEvent(FormDef arg0, IFormReference arg1, String arg2, String arg3) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

	@Override
	public String executeServerEvent(IFormReference ifr, String string, String string1, String string2) {
		General objGeneral = new General();
		String processid = (String) ifr.getValue("processid");
		switch (string1) {
		case "onClick":

			switch (string) {
			case "submit":

				String decision = (String) ifr.getValue("user_action");
				String remarks = (String) ifr.getValue("textarea1");

				JSONObject rem = new JSONObject();
				JSONArray remarr = new JSONArray();
				LocalDateTime ldt = LocalDateTime.now();
				String today = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH).format(ldt);
				rem.put("Activity Name", "Posting");
				rem.put("User Name", ifr.getUserName());
				rem.put("Action", decision);
				rem.put("Comments", remarks);
				rem.put("Action Date", today);

				remarr.add(rem);

				ifr.addDataToGrid("table7", remarr);

				break;
			case "posting":
				try {

					String invoice_number = (String) ifr.getValue("invoicenumber");
					// Preparing Header DATA**************************************************
					MiroPostingHeaderBean mirohead = new MiroPostingHeaderBean();

					String invoice_date = (String) ifr.getValue("invoicedate");
					LocalDateTime ldt1 = LocalDateTime.now();
					String todaysapdate = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt1);
					todaysapdate = todaysapdate + "T00:00:00";
					System.out.println(todaysapdate);
					mirohead.setInvoiceInd("X");
					mirohead.setDocType("RE");
					//mirohead.setPstngDate(todaysapdate);
					mirohead.setPstngDate(objGeneral.sapDateConverter((String)ifr.getValue("posting_date")));

					mirohead.setDocDate(objGeneral.sapDateConverter(invoice_date));
					mirohead.setRefDocNo(invoice_number);
					mirohead.setCompCode((String) ifr.getValue("companycode"));
					mirohead.setDiffInv((String) ifr.getValue("vendorcode"));
					mirohead.setCurrency((String) ifr.getValue("currency"));
					mirohead.setGrossAmount((String) ifr.getValue("invoicetotalamount"));
					mirohead.setIrn((String) ifr.getValue("irnnumber"));
					mirohead.setBlineDate(objGeneral.sapDateConverter(invoice_date));
					mirohead.setHeaderTxt((String) ifr.getValue("Documentheadertext"));
					mirohead.setItemText((String) ifr.getValue("text"));
					mirohead.setSectionCode((String) ifr.getValue("sectioncode"));
					mirohead.setAllocNmbr((String) ifr.getValue("ponumber"));
					mirohead.setBusinessPlace((String) ifr.getValue("businessplace"));

					// set TDS**********************************************
					System.out.println("MIRO Header Bean :: " + mirohead.toString());
					String with_holding_tax = (String) ifr.getValue("withholdingtaxcode");

					ArrayList<WTaxSetBean> tax = new ArrayList<>();

					ArrayList<MiroPostingItemSetBean> lineitem = new ArrayList<MiroPostingItemSetBean>();
					MiroPostingItemSetBean linebean = null;
					ArrayList<ITGLSetBean> itgl = new ArrayList<>();
					// set Line Item Data*********************************************
//					Query = "select ponumber,lineitemnumber,grnquantity,deliverynotegrnnum,fiscalyear,matdocitem,uom,"
//							+ "netpovalue from cmplx_ETB_po_details where procid='" + processid + "'";

					Query = "select etb.poNumber,po.lineitemnumber,etb.quantity,po.deliverynotegrnnum,po.fiscalyear,po.matdocitem,etb.uom,"
							+ "etb.taxableValue from cmplx_ETB_po_details po, cmplx_invoiceDataETB etb "
							+ "where  etb.pinstanceid = po.procid and etb.pinstanceid = '" + processid + "'";
					System.out.println("Query for Line Item data in posting ::: " + Query);
					result = ifr.getDataFromDB(Query);

					String taxcode = (String) ifr.getValue("taxcode");
					float baseamt = 0.00f;
					for (int i = 0; i < result.size(); i++) {

						linebean = new MiroPostingItemSetBean();
						linebean.setRefDocNo(invoice_number);
						linebean.setPoNumber(result.get(i).get(0));
						linebean.setPoItem(result.get(i).get(1));
						linebean.setTaxCode(taxcode);
						linebean.setQuantity(result.get(i).get(2));
						// hard coding some values according to test cases provided
						linebean.setGrnDoc(result.get(i).get(3));
						linebean.setGrnDocYear(result.get(i).get(4));
						linebean.setGrnDocItem(result.get(i).get(5));
						linebean.setCustomsAssesVal("0");
						linebean.setPoUnit(result.get(i).get(6));
						linebean.setCondType("");
						linebean.setItemText((String) ifr.getValue("text"));
						//////////////////////////////////////////////
						linebean.setPrinInvDate(objGeneral.sapDateConverter(invoice_date));
						linebean.setItemAmount(result.get(i).get(7));
						baseamt = baseamt + Float.parseFloat(result.get(i).get(7));

						lineitem.add(linebean);
					}

					if (!"".equalsIgnoreCase(with_holding_tax)) {
						WTaxSetBean taxbean = new WTaxSetBean();

						taxbean.setRefDocNo(invoice_number);
						taxbean.setWiTaxBase(baseamt + "");
						taxbean.setWiTaxCode(with_holding_tax);
						logger.info("POSTING LOG !!");
						taxbean.setWiTaxType(dao.getWithholdingTaxCodeType(with_holding_tax));
						tax.add(taxbean);
					}
					// **************************Posting Start***********************************
					System.out.println("MIRO Line Bean ::: " + linebean.toString());
					MiroRelated miroobj = new MiroRelated();
					MiroBean mirobean = new MiroBean();
					mirobean = miroobj.miroPosting(mirohead, lineitem, tax, itgl);

					if (mirobean.getMessage().contains("Document Posted")) {
						ifr.setValue("fiscalyear", mirobean.getFiscalYear());
						ifr.setValue("textarea2", mirobean.getMessage());
						ifr.setValue("sapdocument", mirobean.getSapDocNo());
						ifr.setValue("totalAmount", mirobean.getTotalAmount());

						String finalpostingdate = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)
								.format(ldt1);
						finalpostingdate = finalpostingdate + " 00:00:00";
						ifr.setValue("postingdate", finalpostingdate);
					} else {
						ifr.setValue("textarea2", mirobean.getMessage());
					}
				} catch (Exception e) {
					System.out.println("Exception :::: " + e);
					e.printStackTrace();
				}
				break;

			default:
				break;
			}

			break;

		case "OnChange":
			switch (string) {
			case "":
				break;

			default:
				break;
			}
			break;
		default:
			break;
		}

		return "";
	}

	@Override
	public String generateHTML(EControl arg0) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

	@Override
	public String getCustomFilterXML(FormDef arg0, IFormReference arg1, String arg2) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

	@Override
	public String introduceWorkItemInWorkFlow(IFormReference arg0, HttpServletRequest arg1, HttpServletResponse arg2) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

	@Override
	public String introduceWorkItemInWorkFlow(IFormReference arg0, HttpServletRequest arg1, HttpServletResponse arg2,
			WorkdeskModel arg3) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

	@Override
	public String setMaskedValue(String arg0, String arg1) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

	@Override
	public JSONArray validateSubmittedForm(FormDef arg0, IFormReference arg1, String arg2) {
		throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
	}

}
