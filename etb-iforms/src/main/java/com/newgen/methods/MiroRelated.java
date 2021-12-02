package com.newgen.methods;

import com.newgen.dto.ITGLSetBean;
import com.newgen.dto.MiroBean;
import com.newgen.dto.MiroPostingHeaderBean;
import com.newgen.dto.MiroPostingItemSetBean;
import com.newgen.dto.WTaxSetBean;
import com.newgen.xml.XMLParser;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class MiroRelated
{
  String outputxmlMiro = "";
  String inputxml = "";
  String outputxml = "";
  String token = "";
  
  public MiroBean miroPosting(MiroPostingHeaderBean head, ArrayList<MiroPostingItemSetBean> item, ArrayList<WTaxSetBean> tax, ArrayList<ITGLSetBean> itgl)
  {
    MiroBean postingbean = new MiroBean();
    General objGeneral = new General();
    try
    {
      JSONObject mainobj = new JSONObject();
      
      JSONArray res = new JSONArray();
      JSONObject resobj = new JSONObject();
      res.put(resobj);
      mainobj.put("Result", res);
      mainobj.put("InvoiceInd", "X");
      mainobj.put("DocType", head.getDocType());
      mainobj.put("DocDate", head.getDocDate());
      mainobj.put("PstngDate", head.getPstngDate());
      mainobj.put("RefDocNo", head.getRefDocNo());
      mainobj.put("CompCode", head.getCompCode());
      mainobj.put("DiffInv", head.getDiffInv());
      mainobj.put("Currency", head.getCurrency());
      mainobj.put("GrossAmount", head.getGrossAmount());
      mainobj.put("CalcTaxInd", head.getCalcTaxInd());
      mainobj.put("Pmnttrms", head.getPmnttrms());
      mainobj.put("BlineDate", head.getBlineDate());
      mainobj.put("HeaderTxt", head.getHeaderTxt());
      mainobj.put("PymtMeth", head.getPymtMeth());
      mainobj.put("AllocNmbr", head.getAllocNmbr());
      mainobj.put("ItemText", head.getItemText());
      mainobj.put("BusinessPlace", head.getBusinessPlace());
      mainobj.put("Irn", head.getIrn());
      mainobj.put("SectionCode", head.getSectionCode());
      mainobj.put("InterRefNo", head.getInterRefNo());
      mainobj.put("BoeNo", head.getBoeNo());
      mainobj.put("BoeDate", head.getBoeDate());
      mainobj.put("BolNo", head.getBolNo());
      mainobj.put("BolDate", head.getBolDate());
      mainobj.put("InvType", head.getInvType());
      mainobj.put("DocketNo", head.getDocketNo());
      mainobj.put("DocketDate", head.getDocketDate());
      
      JSONArray linearr = new JSONArray();
      
      Iterator itrline = item.iterator();
      while (itrline.hasNext())
      {
        JSONObject lineobj = new JSONObject();
        MiroPostingItemSetBean itembean = (MiroPostingItemSetBean)itrline.next();
        
        lineobj.put("RefDocNo", itembean.getRefDocNo());
        lineobj.put("SheetNo", itembean.getSheetNo());
        lineobj.put("PoNumber", itembean.getPoNumber());
        lineobj.put("PoItem", itembean.getPoItem());
        lineobj.put("GrnDoc", itembean.getGrnDoc());
        lineobj.put("GrnDocYear", itembean.getGrnDocYear());
        lineobj.put("GrnDocItem", itembean.getGrnDocItem());
        lineobj.put("TaxCode", itembean.getTaxCode());
        lineobj.put("Quantity", itembean.getQuantity());
        lineobj.put("PoUnit", itembean.getPoUnit());
        lineobj.put("DeCreInd", itembean.getDeCreInd());
        lineobj.put("CondType", itembean.getCondType());
        lineobj.put("ItemText", itembean.getItemText());
        lineobj.put("HsnSac", itembean.getHsnSac());
        lineobj.put("PrinInvNo", itembean.getPrinInvNo());
        lineobj.put("PrinInvItemNo", itembean.getPrinInvItemNo());
        lineobj.put("PrinInvDate", itembean.getPrinInvDate());
        lineobj.put("OrigCtry", itembean.getOrigCtry());
        lineobj.put("PortCode", itembean.getPortCode());
        lineobj.put("PortLoad", itembean.getPortLoad());
        lineobj.put("PortCtry", itembean.getPortCtry());
        lineobj.put("PortEnty", itembean.getPortEnty());
        lineobj.put("TranMode", itembean.getTranMode());
        lineobj.put("BcdRate", itembean.getBcdRate());
        lineobj.put("SwsRate", itembean.getSwsRate());
        lineobj.put("ItemAmount", itembean.getItemAmount());
        lineobj.put("CustomsAssesVal", itembean.getCustomsAssesVal());
        lineobj.put("BasicValue", itembean.getBasicValue());
        lineobj.put("FreighChrg", itembean.getFreighChrg());
        lineobj.put("InsurChrg", itembean.getInsurChrg());
        lineobj.put("MiscChrg", itembean.getMiscChrg());
        lineobj.put("PortChrg", itembean.getPortChrg());
        lineobj.put("HandChrg", itembean.getHandChrg());
        lineobj.put("CfscChrg", itembean.getCfscChrg());
        lineobj.put("StorChrg", itembean.getStorChrg());
        lineobj.put("StacChrg", itembean.getStacChrg());
        lineobj.put("TranChrg", itembean.getTranChrg());
        lineobj.put("CranChrg", itembean.getCranChrg());
        lineobj.put("ServChrg", itembean.getServChrg());
        lineobj.put("EdiChrg", itembean.getEdiChrg());
        lineobj.put("OthcChrg", itembean.getOthcChrg());
        lineobj.put("ImportChrg", itembean.getImportChrg());
        lineobj.put("Bo3Chrg", itembean.getBo3Chrg());
        lineobj.put("DutyValue", itembean.getDutyValue());
        lineobj.put("CgstRate", itembean.getCgstRate());
        lineobj.put("SgstRate", itembean.getSgstRate());
        lineobj.put("IgstRate", itembean.getIgstRate());
        lineobj.put("CgstAmount", itembean.getCgstAmount());
        lineobj.put("SgstAmount", itembean.getSgstAmount());
        lineobj.put("IgstAmount", itembean.getIgstAmount());
        
        linearr.put(lineobj);
      }
      mainobj.put("ItemSet", linearr);
      
      JSONArray taxarr = new JSONArray();
      
      Iterator itrtax = tax.iterator();
      while (itrtax.hasNext())
      {
        JSONObject taxobj = new JSONObject();
        WTaxSetBean taxbean = (WTaxSetBean)itrtax.next();
        
        taxobj.put("RefDocNo", taxbean.getRefDocNo());
        taxobj.put("WiTaxType", taxbean.getWiTaxType());
        taxobj.put("WiTaxCode", taxbean.getWiTaxCode());
        taxobj.put("WiTaxBase", taxbean.getWiTaxBase());
        
        taxarr.put(taxobj);
      }
      mainobj.put("WTaxSet", taxarr);
      
      JSONArray itglarr = new JSONArray();
      
      Iterator itritgl = itgl.iterator();
      while (itritgl.hasNext())
      {
        JSONObject itglobj = new JSONObject();
        ITGLSetBean itglbean = (ITGLSetBean)itritgl.next();
        
        itglobj.put("RefDocNo", itglbean.getRefDocNo());
        itglobj.put("GlAccount", itglbean.getGlAccount());
        itglobj.put("ItemAmount", itglbean.getItemAmount());
        itglobj.put("DbCrInd", itglbean.getDbCrInd());
        itglobj.put("TaxCode", itglbean.getTaxCode());
        itglobj.put("Costcenter", itglbean.getCostcenter());
        itglobj.put("ProfitCtr", itglbean.getProfitCtr());
        itglobj.put("Plant", itglbean.getPlant());
        
        itglarr.put(itglobj);
      }
      mainobj.put("ITGLSet", itglarr);
      
      String inputjson = mainobj.toString();
      System.out.println("Input MIRO JSON :::: " + inputjson);
      
      this.outputxmlMiro = objGeneral.miroPosting(inputjson);
      
      XMLParser xmlParser = new XMLParser();
      xmlParser.setInputXML(this.outputxmlMiro);
      
      System.out.println("PstngDate :: " + xmlParser.getValueOf("d:PstngDate"));
      
      System.out.println("Amount  :: " + xmlParser.getValueOf("d:GrossAmount"));
      String message = xmlParser.getValueOf("d:Message");
      System.out.println("Message ::: " + xmlParser.getValueOf("d:Message"));
      
      String fiscalyyr = null;String sapdoc = null;
      if (message.contains("Document Posted Successfully"))
      {
        String[] a = message.split("#");
        String[] value = a[1].split(" ");
        
        System.out.println("Invoice Doc Number ::: " + value[1]);
        System.out.println("Fiscal year ::: " + value[3]);
        fiscalyyr = value[3];
        sapdoc = value[1];
      }
      else
      {
        fiscalyyr = "";
        sapdoc = "";
      }
      postingbean.setFiscalYear(fiscalyyr);
      postingbean.setSapDocNo(sapdoc);
      postingbean.setTotalAmount(xmlParser.getValueOf("d:GrossAmount"));
      postingbean.setPostingDate(xmlParser.getValueOf("d:PstngDate"));
      postingbean.setMessage(xmlParser.getValueOf("d:Message"));
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception occured ::: " + e);
    }
    return postingbean;
  }
}
