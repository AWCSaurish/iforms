package com.newgen.methods;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.newgen.dto.POBean;
import com.newgen.dto.POHistoryBean;
import com.newgen.dto.PoDetailsBean;
import com.newgen.dto.SPMInvoiceBean;
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PORelated
{
  public ArrayList<POBean> getPODetails(String filter)
  {
    POBean pobean = null;
    General objGeneral = new General();
    ArrayList<POBean> list = new ArrayList();
    
    String outputjson = objGeneral.poPullRequest(filter, objGeneral.popullurl);
    try
    {
      JSONObject obj = new JSONObject(outputjson);
      JSONObject d = obj.getJSONObject("d");
      JSONArray arr = d.getJSONArray("results");
      for (int i = 0; i < arr.length(); i++)
      {
        pobean = new POBean();
        pobean.setPoNumber(arr.getJSONObject(i).optString("PoNumber"));
        pobean.setDocDate(arr.getJSONObject(i).optString("DocDate"));
        pobean.setPoType(arr.getJSONObject(i).optString("PoType"));
        pobean.setVendor(arr.getJSONObject(i).optString("Vendor"));
        pobean.setConditionDoc(arr.getJSONObject(i).optString("ConditionDoc"));
        pobean.setConditionDocItem(arr.getJSONObject(i).optString("ConditionDocItem"));
        pobean.setConditionType(arr.getJSONObject(i).optString("ConditionType"));
        pobean.setDescription(arr.getJSONObject(i).optString("Description"));
        pobean.setPercentage(arr.getJSONObject(i).optString("Percentage"));
        pobean.setConditionValue(arr.getJSONObject(i).optString("ConditionValue"));
        pobean.setCalculationType(arr.getJSONObject(i).optString("CalculationType"));
        pobean.setCurrency(arr.getJSONObject(i).optString("Currency"));
        pobean.setExchangeRate(arr.getJSONObject(i).optString("ExchangeRate"));
        pobean.setMessage(arr.getJSONObject(i).optString("Message"));
        list.add(pobean);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Exception Occured..!!! :::" + e);
    }
    return list;
  }
  
  public ArrayList<PoDetailsBean> getPOLines(String filter)
  {
    General objGeneral = new General();
    ArrayList<PoDetailsBean> list = new ArrayList();
    PoDetailsBean bean = null;
    try
    {
      String outputjson = objGeneral.poPullRequest(filter, objGeneral.polineurl);
      JSONObject obj = new JSONObject(outputjson);
      JSONObject d = obj.getJSONObject("d");
      JSONArray arr = d.getJSONArray("results");
      for (int i = 0; i < arr.length(); i++)
      {
        bean = new PoDetailsBean();
        bean.setPoNumber(arr.getJSONObject(i).optString("PoNumber"));
        bean.setPoItem(arr.getJSONObject(i).optString("PoItem"));
        bean.setCompanyCode(arr.getJSONObject(i).optString("CompanyCode"));
        bean.setPurchOrg(arr.getJSONObject(i).optString("PurchOrg"));
        bean.setPurchGroup(arr.getJSONObject(i).optString("PurchGroup"));
        bean.setPrNumber(arr.getJSONObject(i).optString("PrNumber"));
        bean.setPrItem(arr.getJSONObject(i).optString("PrItem"));
        bean.setDelIndicator(arr.getJSONObject(i).optString("DelIndicator"));
        bean.setPoDate(arr.getJSONObject(i).optString("PoDate"));
        bean.setPoType(arr.getJSONObject(i).optString("PoType"));
        bean.setIncoterm1(arr.getJSONObject(i).optString("Incoterm1"));
        bean.setIncoterm2(arr.getJSONObject(i).optString("Incoterm2"));
        bean.setVendor(arr.getJSONObject(i).optString("Vendor"));
        bean.setName(arr.getJSONObject(i).optString("Name"));
        bean.setReleaseState(arr.getJSONObject(i).optString("ReleaseState"));
        bean.setPlant(arr.getJSONObject(i).optString("Plant"));
        bean.setMaterial(arr.getJSONObject(i).optString("Material"));
        bean.setTextInfo(arr.getJSONObject(i).optString("TextInfo"));
        bean.setControlCode(arr.getJSONObject(i).optString("ControlCode"));
        bean.setValuationType(arr.getJSONObject(i).optString("ValuationType"));
        bean.setBatch(arr.getJSONObject(i).optString("Batch"));
        bean.setSerialNumber(arr.getJSONObject(i).optString("SerialNumber"));
        bean.setStorageLoc(arr.getJSONObject(i).optString("StorageLoc"));
        bean.setItemCat(arr.getJSONObject(i).optString("ItemCat"));
        bean.setAccAssignCat(arr.getJSONObject(i).optString("AccAssignCat"));
        bean.setManufactNumber(arr.getJSONObject(i).optString("ManufactNumber"));
        bean.setMaterialGroup(arr.getJSONObject(i).optString("MaterialGroup"));
        bean.setProfitCenter(arr.getJSONObject(i).optString("ProfitCenter"));
        bean.setAssetNumber(arr.getJSONObject(i).optString("AssetNumber"));
        bean.setAssetSubnum(arr.getJSONObject(i).optString("AssetSubnum"));
        bean.setWbs(arr.getJSONObject(i).optString("Wbs"));
        bean.setNetworkNumber(arr.getJSONObject(i).optString("NetworkNumber"));
        bean.setSalesDoc(arr.getJSONObject(i).optString("SalesDoc"));
        bean.setSalesItem(arr.getJSONObject(i).optString("SalesItem"));
        bean.setOrder(arr.getJSONObject(i).optString("Order"));
        bean.setCostCenter(arr.getJSONObject(i).optString("CostCenter"));
        bean.setCostElement(arr.getJSONObject(i).optString("CostElement"));
        bean.setFuncArea(arr.getJSONObject(i).optString("FuncArea"));
        bean.setQuantity(arr.getJSONObject(i).optString("Quantity"));
        bean.setUom(arr.getJSONObject(i).optString("Uom"));
        bean.setCurrency(arr.getJSONObject(i).optString("Currency"));
        bean.setExchangeRate(arr.getJSONObject(i).optString("ExchangeRate"));
        bean.setNetPrice(arr.getJSONObject(i).optString("NetPrice"));
        bean.setNetValue(arr.getJSONObject(i).optString("NetValue"));
        bean.setTaxCode(arr.getJSONObject(i).optString("TaxCode"));
        bean.setIgstPer(arr.getJSONObject(i).optString("IgstPer"));
        bean.setIgstVal(arr.getJSONObject(i).optString("IgstVal"));
        bean.setCgstPer(arr.getJSONObject(i).optString("CgstPer"));
        bean.setCgstVal(arr.getJSONObject(i).optString("CgstVal"));
        bean.setSgstPer(arr.getJSONObject(i).optString("SgstPer"));
        bean.setSgstVal(arr.getJSONObject(i).optString("SgstVal"));
        bean.setCondDocnumber(arr.getJSONObject(i).optString("CondDocnumber"));
        bean.setTaxNumber(arr.getJSONObject(i).optString("TaxNumber"));
        bean.setCustTaxStcd3(arr.getJSONObject(i).optString("CustTaxStcd3"));
        bean.setMessage(arr.getJSONObject(i).optString("Message"));
        
        list.add(bean);
      }
    }
    catch (Exception e)
    {
      System.out.println("Exception ... ::: " + e);
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<POHistoryBean> getPOHistory(String filter)
  {
    General objGeneral = new General();
    ArrayList<POHistoryBean> list = new ArrayList();
    POHistoryBean bean = null;
    try
    {
      String outputjson = objGeneral.poPullRequest(filter, objGeneral.pohisturl);
      JSONObject obj = new JSONObject(outputjson);
      JSONObject d = obj.getJSONObject("d");
      JSONArray arr = d.getJSONArray("results");
      for (int i = 0; i < arr.length(); i++)
      {
        bean = new POHistoryBean();
        
        bean.setPoNumber(arr.getJSONObject(i).optString("PoNumber"));
        bean.setPoItem(arr.getJSONObject(i).optString("PoItem"));
        bean.setDeliveryNumber(arr.getJSONObject(i).optString("DeliveryNumber"));
        bean.setDeliveryItem(arr.getJSONObject(i).optString("DeliveryItem"));
        bean.setRefDocNo(arr.getJSONObject(i).optString("RefDocNo"));
        bean.setMatDocNo(arr.getJSONObject(i).optString("MatDocNo"));
        bean.setMatDocItem(arr.getJSONObject(i).optString("MatDocItem"));
        bean.setDocDate(arr.getJSONObject(i).optString("DocDate"));
        bean.setPostDate(arr.getJSONObject(i).optString("PostDate"));
        bean.setPlant(arr.getJSONObject(i).optString("Plant"));
        bean.setMaterial(arr.getJSONObject(i).optString("Material"));
        bean.setStorageLoc(arr.getJSONObject(i).optString("StorageLoc"));
        bean.setBatch(arr.getJSONObject(i).optString("Batch"));
        bean.setSerialNo(arr.getJSONObject(i).optString("SerialNo"));
        bean.setProfitCenter(arr.getJSONObject(i).optString("ProfitCenter"));
        bean.setQuantity(arr.getJSONObject(i).optString("Quantity"));
        bean.setUom(arr.getJSONObject(i).optString("Uom"));
        bean.setMovType(arr.getJSONObject(i).optString("MovType"));
        bean.setIncoterms(arr.getJSONObject(i).optString("Incoterms"));
        bean.setAmountDoccurr(arr.getJSONObject(i).optString("AmountDoccurr"));
        bean.setCurrency(arr.getJSONObject(i).optString("Currency"));
        bean.setAmountLoccurr(arr.getJSONObject(i).optString("AmountLoccurr"));
        bean.setDelvAmtDoccurr(arr.getJSONObject(i).optString("DelvAmtDoccurr"));
        bean.setDelvCurrency(arr.getJSONObject(i).optString("DelvCurrency"));
        bean.setDelvAmtLoccurr(arr.getJSONObject(i).optString("DelvAmtLoccurr"));
        bean.setDcIndicator(arr.getJSONObject(i).optString("DcIndicator"));
        bean.setFiscalYear(arr.getJSONObject(i).optString("FiscalYear"));
        bean.setVendor(arr.getJSONObject(i).optString("Vendor"));
        bean.setName(arr.getJSONObject(i).optString("Name"));
        bean.setTaxNumber(arr.getJSONObject(i).optString("TaxNumber"));
        bean.setMessage(arr.getJSONObject(i).optString("Message"));
        
        list.add(bean);
      }
    }
    catch (Exception e)
    {
      System.out.println("Exception ... ::: " + e);
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<SPMInvoiceBean> getPrincipleInvoice(String filter)
  {
    General objGeneral = new General();
    ArrayList<SPMInvoiceBean> list = new ArrayList();
    SPMInvoiceBean bean = null;
    try
    {
      String outputjson = objGeneral.poPullRequest(filter, objGeneral.pohisturl);
      JSONObject obj = new JSONObject(outputjson);
      JSONObject d = obj.getJSONObject("d");
      JSONArray arr = d.getJSONArray("results");
      for (int i = 0; i < arr.length(); i++)
      {
        bean = new SPMInvoiceBean();
        
        bean.setPindt(arr.getJSONObject(i).optString("Pindt"));
        bean.setFupdt(arr.getJSONObject(i).optString("Fupdt"));
        bean.setZuonr(arr.getJSONObject(i).optString("Zuonr"));
        bean.setZinitno(arr.getJSONObject(i).optString("Zinitno"));
        bean.setZpodoc(arr.getJSONObject(i).optString("Zpodoc"));
        bean.setZpolitm(arr.getJSONObject(i).optString("Zpolitm"));
        bean.setLifnr(arr.getJSONObject(i).optString("Lifnr"));
        bean.setBoenr(arr.getJSONObject(i).optString("Boenr"));
        bean.setBolnr(arr.getJSONObject(i).optString("Bolnr"));
        bean.setBoldt(arr.getJSONObject(i).optString("Boldt"));
        bean.setMatnr(arr.getJSONObject(i).optString("Matnr"));
        bean.setZpartno(arr.getJSONObject(i).optString("Zpartno"));
        bean.setZcouorg(arr.getJSONObject(i).optString("Zcouorg"));
        bean.setZqtmat(arr.getJSONObject(i).optString("Zqtmat"));
        bean.setZcode(arr.getJSONObject(i).optString("Zcode"));
        bean.setMeins(arr.getJSONObject(i).optString("Meins"));
        bean.setZunrate(arr.getJSONObject(i).optString("Zunrate"));
        bean.setZamtdoc(arr.getJSONObject(i).optString("Zamtdoc"));
        bean.setZotamt(arr.getJSONObject(i).optString("Zotamt"));
        bean.setZdisamt(arr.getJSONObject(i).optString("Zdisamt"));
        bean.setZgstper(arr.getJSONObject(i).optString("Zgstper"));
        bean.setZgstamt(arr.getJSONObject(i).optString("Zgstamt"));
        bean.setSgtxt(arr.getJSONObject(i).optString("Sgtxt"));
        bean.setZlamt(arr.getJSONObject(i).optString("Zlamt"));
        bean.setZiamt(arr.getJSONObject(i).optString("Ziamt"));
        bean.setZcasno(arr.getJSONObject(i).optString("Zcasno"));
        bean.setZexphs(arr.getJSONObject(i).optString("Zexphs"));
        bean.setZclchg(arr.getJSONObject(i).optString("Zclchg"));
        bean.setZfee(arr.getJSONObject(i).optString("Zfee"));
        bean.setZdefch(arr.getJSONObject(i).optString("Zdefch"));
        bean.setZdep(arr.getJSONObject(i).optString("Zdep"));
        bean.setZemchg(arr.getJSONObject(i).optString("Zemchg"));
        bean.setZeichg(arr.getJSONObject(i).optString("Zeichg"));
        bean.setZfwchg(arr.getJSONObject(i).optString("Zfwchg"));
        bean.setZfrchg(arr.getJSONObject(i).optString("Zfrchg"));
        bean.setZsercr(arr.getJSONObject(i).optString("Zsercr"));
        bean.setZhrmare(arr.getJSONObject(i).optString("Zhrmare"));
        bean.setZimfee(arr.getJSONObject(i).optString("Zimfee"));
        bean.setZinfrch(arr.getJSONObject(i).optString("Zinfrch"));
        bean.setZinchg(arr.getJSONObject(i).optString("Zinchg"));
        bean.setZinsfe(arr.getJSONObject(i).optString("Zinsfe"));
        bean.setZinser(arr.getJSONObject(i).optString("Zinser"));
        bean.setZlachg(arr.getJSONObject(i).optString("Zlachg"));
        bean.setZlecrp(arr.getJSONObject(i).optString("Zlecrp"));
        bean.setZprtr(arr.getJSONObject(i).optString("Zprtr"));
        bean.setZprser(arr.getJSONObject(i).optString("Zprser"));
        bean.setZrechg(arr.getJSONObject(i).optString("Zrechg"));
        bean.setZrepchg(arr.getJSONObject(i).optString("Zrepchg"));
        bean.setZrcchg(arr.getJSONObject(i).optString("Zrcchg"));
        bean.setZsahchg(arr.getJSONObject(i).optString("Zsahchg"));
        bean.setZspfrsp(arr.getJSONObject(i).optString("Zspfrsp"));
        bean.setZspser(arr.getJSONObject(i).optString("Zspser"));
        bean.setZtax(arr.getJSONObject(i).optString("Ztax"));
        bean.setZdiprha(arr.getJSONObject(i).optString("Zdiprha"));
        bean.setZpchchg(arr.getJSONObject(i).optString("Zpchchg"));
        bean.setZpchtchg(arr.getJSONObject(i).optString("Zpchtchg"));
        bean.setZmaz(arr.getJSONObject(i).optString("Zmaz"));
        bean.setZtoinamt(arr.getJSONObject(i).optString("Ztoinamt"));
        bean.setZpay(arr.getJSONObject(i).optString("Zpay"));
        bean.setZdefal(arr.getJSONObject(i).optString("Zdefal"));
        bean.setZdisin(arr.getJSONObject(i).optString("Zdisin"));
        bean.setZdisco(arr.getJSONObject(i).optString("Zdisco"));
        bean.setZdissp(arr.getJSONObject(i).optString("Zdissp"));
        bean.setZalchg(arr.getJSONObject(i).optString("Zalchg"));
        bean.setZprmra(arr.getJSONObject(i).optString("Zprmra"));
        bean.setZrebat(arr.getJSONObject(i).optString("Zrebat"));
        bean.setZscral(arr.getJSONObject(i).optString("Zscral"));
        bean.setZtpall(arr.getJSONObject(i).optString("Ztpall"));
        bean.setMessage(arr.getJSONObject(i).optString("Message"));
        
        list.add(bean);
      }
    }
    catch (Exception e)
    {
      System.out.println("Exception ... ::: " + e);
      e.printStackTrace();
    }
    return list;
  }
}
