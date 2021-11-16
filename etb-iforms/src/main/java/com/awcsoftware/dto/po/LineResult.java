package com.awcsoftware.dto.po;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LineResult{
    @JsonProperty("AssetSubnum") 
    private String assetSubnum;
    @JsonProperty("FuncArea") 
    private String funcArea;
    @JsonProperty("IgstPer") 
    private String igstPer;
    @JsonProperty("DelIndicator") 
    private boolean delIndicator;
    @JsonProperty("AssetNumber") 
    private String assetNumber;
    @JsonProperty("Name") 
    private String name;
    @JsonProperty("PoItem") 
    private String poItem;
    @JsonProperty("PackLineno") 
    private String packLineno;
    @JsonProperty("PurchGroup") 
    private String purchGroup;
    @JsonProperty("ReleaseState") 
    private String releaseState;
    @JsonProperty("Currency") 
    private String currency;
    @JsonProperty("TextInfo") 
    private String textInfo;
    @JsonProperty("ServiceText") 
    private String serviceText;
    @JsonProperty("ManufactNumber") 
    private String manufactNumber;
    @JsonProperty("Order") 
    private String order;
    @JsonProperty("PoNumber") 
    private String poNumber;
    @JsonProperty("CondDocnumber") 
    private String condDocnumber;
    @JsonProperty("PrNumber") 
    private String prNumber;
    @JsonProperty("ServiceTaxcd") 
    private String serviceTaxcd;
    @JsonProperty("CustTaxStcd3") 
    private String custTaxStcd3;
    @JsonProperty("PoDate") 
    private Object poDate;
    @JsonProperty("PurchOrg") 
    private String purchOrg;
    @JsonProperty("NetPrice") 
    private String netPrice;
    @JsonProperty("SerialNumber") 
    private String serialNumber;
    @JsonProperty("MaterialGroup") 
    private String materialGroup;
    @JsonProperty("PrItem") 
    private String prItem;
    @JsonProperty("NetValue") 
    private String netValue;
    @JsonProperty("PoType") 
    private String poType;
    @JsonProperty("Incoterm1") 
    private String incoterm1;
    @JsonProperty("StorageLoc") 
    private String storageLoc;
    @JsonProperty("Incoterm2") 
    private String incoterm2;
    @JsonProperty("ExchangeRate") 
    private String exchangeRate;
    @JsonProperty("Message") 
    private String message;
    @JsonProperty("NetworkNumber") 
    private String networkNumber;
    @JsonProperty("Plant") 
    private String plant;
    @JsonProperty("PackNo") 
    private String packNo;
    @JsonProperty("CostCenter") 
    private String costCenter;
    @JsonProperty("TaxCode") 
    private String taxCode;
    @JsonProperty("Batch") 
    private String batch;
    @JsonProperty("CostElement") 
    private String costElement;
    @JsonProperty("TaxNumber") 
    private String taxNumber;
    private Metadata __metadata;
    @JsonProperty("SericeTaxtarrif") 
    private String sericeTaxtarrif;
    @JsonProperty("ValuationType") 
    private String valuationType;
    @JsonProperty("SalesDoc") 
    private String salesDoc;
    @JsonProperty("ServiceQty") 
    private String serviceQty;
    @JsonProperty("ProfitCenter") 
    private String profitCenter;
    @JsonProperty("Wbs") 
    private String wbs;
    @JsonProperty("Quantity") 
    private String quantity;
    @JsonProperty("Material") 
    private String material;
    @JsonProperty("Vendor") 
    private String vendor;
    @JsonProperty("SalesItem") 
    private String salesItem;
    @JsonProperty("ControlCode") 
    private String controlCode;
    @JsonProperty("Uom") 
    private String uom;
    @JsonProperty("CgstVal") 
    private String cgstVal;
    @JsonProperty("AccAssignCat") 
    private String accAssignCat;
    @JsonProperty("IgstVal") 
    private String igstVal;
    @JsonProperty("CgstPer") 
    private String cgstPer;
    @JsonProperty("ItemCat") 
    private String itemCat;
    @JsonProperty("SgstPer") 
    private String sgstPer;
    @JsonProperty("ServiceMeins") 
    private String serviceMeins;
    @JsonProperty("CompanyCode") 
    private String companyCode;
    @JsonProperty("SgstVal") 
    private String sgstVal;
	public String getAssetSubnum() {
		return assetSubnum;
	}
	public void setAssetSubnum(String assetSubnum) {
		this.assetSubnum = assetSubnum;
	}
	public String getFuncArea() {
		return funcArea;
	}
	public void setFuncArea(String funcArea) {
		this.funcArea = funcArea;
	}
	public String getIgstPer() {
		return igstPer;
	}
	public void setIgstPer(String igstPer) {
		this.igstPer = igstPer;
	}
	public boolean isDelIndicator() {
		return delIndicator;
	}
	public void setDelIndicator(boolean delIndicator) {
		this.delIndicator = delIndicator;
	}
	public String getAssetNumber() {
		return assetNumber;
	}
	public void setAssetNumber(String assetNumber) {
		this.assetNumber = assetNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoItem() {
		return poItem;
	}
	public void setPoItem(String poItem) {
		this.poItem = poItem;
	}
	public String getPackLineno() {
		return packLineno;
	}
	public void setPackLineno(String packLineno) {
		this.packLineno = packLineno;
	}
	public String getPurchGroup() {
		return purchGroup;
	}
	public void setPurchGroup(String purchGroup) {
		this.purchGroup = purchGroup;
	}
	public String getReleaseState() {
		return releaseState;
	}
	public void setReleaseState(String releaseState) {
		this.releaseState = releaseState;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTextInfo() {
		return textInfo;
	}
	public void setTextInfo(String textInfo) {
		this.textInfo = textInfo;
	}
	public String getServiceText() {
		return serviceText;
	}
	public void setServiceText(String serviceText) {
		this.serviceText = serviceText;
	}
	public String getManufactNumber() {
		return manufactNumber;
	}
	public void setManufactNumber(String manufactNumber) {
		this.manufactNumber = manufactNumber;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getCondDocnumber() {
		return condDocnumber;
	}
	public void setCondDocnumber(String condDocnumber) {
		this.condDocnumber = condDocnumber;
	}
	public String getPrNumber() {
		return prNumber;
	}
	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}
	public String getServiceTaxcd() {
		return serviceTaxcd;
	}
	public void setServiceTaxcd(String serviceTaxcd) {
		this.serviceTaxcd = serviceTaxcd;
	}
	public String getCustTaxStcd3() {
		return custTaxStcd3;
	}
	public void setCustTaxStcd3(String custTaxStcd3) {
		this.custTaxStcd3 = custTaxStcd3;
	}
	public Object getPoDate() {
		return poDate;
	}
	public void setPoDate(Object poDate) {
		this.poDate = poDate;
	}
	public String getPurchOrg() {
		return purchOrg;
	}
	public void setPurchOrg(String purchOrg) {
		this.purchOrg = purchOrg;
	}
	public String getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(String netPrice) {
		this.netPrice = netPrice;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getMaterialGroup() {
		return materialGroup;
	}
	public void setMaterialGroup(String materialGroup) {
		this.materialGroup = materialGroup;
	}
	public String getPrItem() {
		return prItem;
	}
	public void setPrItem(String prItem) {
		this.prItem = prItem;
	}
	public String getNetValue() {
		return netValue;
	}
	public void setNetValue(String netValue) {
		this.netValue = netValue;
	}
	public String getPoType() {
		return poType;
	}
	public void setPoType(String poType) {
		this.poType = poType;
	}
	public String getIncoterm1() {
		return incoterm1;
	}
	public void setIncoterm1(String incoterm1) {
		this.incoterm1 = incoterm1;
	}
	public String getStorageLoc() {
		return storageLoc;
	}
	public void setStorageLoc(String storageLoc) {
		this.storageLoc = storageLoc;
	}
	public String getIncoterm2() {
		return incoterm2;
	}
	public void setIncoterm2(String incoterm2) {
		this.incoterm2 = incoterm2;
	}
	public String getExchangeRate() {
		return exchangeRate;
	}
	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNetworkNumber() {
		return networkNumber;
	}
	public void setNetworkNumber(String networkNumber) {
		this.networkNumber = networkNumber;
	}
	public String getPlant() {
		return plant;
	}
	public void setPlant(String plant) {
		this.plant = plant;
	}
	public String getPackNo() {
		return packNo;
	}
	public void setPackNo(String packNo) {
		this.packNo = packNo;
	}
	public String getCostCenter() {
		return costCenter;
	}
	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	public String getTaxCode() {
		return taxCode;
	}
	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getCostElement() {
		return costElement;
	}
	public void setCostElement(String costElement) {
		this.costElement = costElement;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}
	public Metadata get__metadata() {
		return __metadata;
	}
	public void set__metadata(Metadata __metadata) {
		this.__metadata = __metadata;
	}
	public String getSericeTaxtarrif() {
		return sericeTaxtarrif;
	}
	public void setSericeTaxtarrif(String sericeTaxtarrif) {
		this.sericeTaxtarrif = sericeTaxtarrif;
	}
	public String getValuationType() {
		return valuationType;
	}
	public void setValuationType(String valuationType) {
		this.valuationType = valuationType;
	}
	public String getSalesDoc() {
		return salesDoc;
	}
	public void setSalesDoc(String salesDoc) {
		this.salesDoc = salesDoc;
	}
	public String getServiceQty() {
		return serviceQty;
	}
	public void setServiceQty(String serviceQty) {
		this.serviceQty = serviceQty;
	}
	public String getProfitCenter() {
		return profitCenter;
	}
	public void setProfitCenter(String profitCenter) {
		this.profitCenter = profitCenter;
	}
	public String getWbs() {
		return wbs;
	}
	public void setWbs(String wbs) {
		this.wbs = wbs;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getSalesItem() {
		return salesItem;
	}
	public void setSalesItem(String salesItem) {
		this.salesItem = salesItem;
	}
	public String getControlCode() {
		return controlCode;
	}
	public void setControlCode(String controlCode) {
		this.controlCode = controlCode;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public String getCgstVal() {
		return cgstVal;
	}
	public void setCgstVal(String cgstVal) {
		this.cgstVal = cgstVal;
	}
	public String getAccAssignCat() {
		return accAssignCat;
	}
	public void setAccAssignCat(String accAssignCat) {
		this.accAssignCat = accAssignCat;
	}
	public String getIgstVal() {
		return igstVal;
	}
	public void setIgstVal(String igstVal) {
		this.igstVal = igstVal;
	}
	public String getCgstPer() {
		return cgstPer;
	}
	public void setCgstPer(String cgstPer) {
		this.cgstPer = cgstPer;
	}
	public String getItemCat() {
		return itemCat;
	}
	public void setItemCat(String itemCat) {
		this.itemCat = itemCat;
	}
	public String getSgstPer() {
		return sgstPer;
	}
	public void setSgstPer(String sgstPer) {
		this.sgstPer = sgstPer;
	}
	public String getServiceMeins() {
		return serviceMeins;
	}
	public void setServiceMeins(String serviceMeins) {
		this.serviceMeins = serviceMeins;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getSgstVal() {
		return sgstVal;
	}
	public void setSgstVal(String sgstVal) {
		this.sgstVal = sgstVal;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((__metadata == null) ? 0 : __metadata.hashCode());
		result = prime * result + ((accAssignCat == null) ? 0 : accAssignCat.hashCode());
		result = prime * result + ((assetNumber == null) ? 0 : assetNumber.hashCode());
		result = prime * result + ((assetSubnum == null) ? 0 : assetSubnum.hashCode());
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + ((cgstPer == null) ? 0 : cgstPer.hashCode());
		result = prime * result + ((cgstVal == null) ? 0 : cgstVal.hashCode());
		result = prime * result + ((companyCode == null) ? 0 : companyCode.hashCode());
		result = prime * result + ((condDocnumber == null) ? 0 : condDocnumber.hashCode());
		result = prime * result + ((controlCode == null) ? 0 : controlCode.hashCode());
		result = prime * result + ((costCenter == null) ? 0 : costCenter.hashCode());
		result = prime * result + ((costElement == null) ? 0 : costElement.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		result = prime * result + ((custTaxStcd3 == null) ? 0 : custTaxStcd3.hashCode());
		result = prime * result + (delIndicator ? 1231 : 1237);
		result = prime * result + ((exchangeRate == null) ? 0 : exchangeRate.hashCode());
		result = prime * result + ((funcArea == null) ? 0 : funcArea.hashCode());
		result = prime * result + ((igstPer == null) ? 0 : igstPer.hashCode());
		result = prime * result + ((igstVal == null) ? 0 : igstVal.hashCode());
		result = prime * result + ((incoterm1 == null) ? 0 : incoterm1.hashCode());
		result = prime * result + ((incoterm2 == null) ? 0 : incoterm2.hashCode());
		result = prime * result + ((itemCat == null) ? 0 : itemCat.hashCode());
		result = prime * result + ((manufactNumber == null) ? 0 : manufactNumber.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		result = prime * result + ((materialGroup == null) ? 0 : materialGroup.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((netPrice == null) ? 0 : netPrice.hashCode());
		result = prime * result + ((netValue == null) ? 0 : netValue.hashCode());
		result = prime * result + ((networkNumber == null) ? 0 : networkNumber.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((packLineno == null) ? 0 : packLineno.hashCode());
		result = prime * result + ((packNo == null) ? 0 : packNo.hashCode());
		result = prime * result + ((plant == null) ? 0 : plant.hashCode());
		result = prime * result + ((poDate == null) ? 0 : poDate.hashCode());
		result = prime * result + ((poItem == null) ? 0 : poItem.hashCode());
		result = prime * result + ((poNumber == null) ? 0 : poNumber.hashCode());
		result = prime * result + ((poType == null) ? 0 : poType.hashCode());
		result = prime * result + ((prItem == null) ? 0 : prItem.hashCode());
		result = prime * result + ((prNumber == null) ? 0 : prNumber.hashCode());
		result = prime * result + ((profitCenter == null) ? 0 : profitCenter.hashCode());
		result = prime * result + ((purchGroup == null) ? 0 : purchGroup.hashCode());
		result = prime * result + ((purchOrg == null) ? 0 : purchOrg.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((releaseState == null) ? 0 : releaseState.hashCode());
		result = prime * result + ((salesDoc == null) ? 0 : salesDoc.hashCode());
		result = prime * result + ((salesItem == null) ? 0 : salesItem.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		result = prime * result + ((sericeTaxtarrif == null) ? 0 : sericeTaxtarrif.hashCode());
		result = prime * result + ((serviceMeins == null) ? 0 : serviceMeins.hashCode());
		result = prime * result + ((serviceQty == null) ? 0 : serviceQty.hashCode());
		result = prime * result + ((serviceTaxcd == null) ? 0 : serviceTaxcd.hashCode());
		result = prime * result + ((serviceText == null) ? 0 : serviceText.hashCode());
		result = prime * result + ((sgstPer == null) ? 0 : sgstPer.hashCode());
		result = prime * result + ((sgstVal == null) ? 0 : sgstVal.hashCode());
		result = prime * result + ((storageLoc == null) ? 0 : storageLoc.hashCode());
		result = prime * result + ((taxCode == null) ? 0 : taxCode.hashCode());
		result = prime * result + ((taxNumber == null) ? 0 : taxNumber.hashCode());
		result = prime * result + ((textInfo == null) ? 0 : textInfo.hashCode());
		result = prime * result + ((uom == null) ? 0 : uom.hashCode());
		result = prime * result + ((valuationType == null) ? 0 : valuationType.hashCode());
		result = prime * result + ((vendor == null) ? 0 : vendor.hashCode());
		result = prime * result + ((wbs == null) ? 0 : wbs.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LineResult other = (LineResult) obj;
		if (__metadata == null) {
			if (other.__metadata != null)
				return false;
		} else if (!__metadata.equals(other.__metadata))
			return false;
		if (accAssignCat == null) {
			if (other.accAssignCat != null)
				return false;
		} else if (!accAssignCat.equals(other.accAssignCat))
			return false;
		if (assetNumber == null) {
			if (other.assetNumber != null)
				return false;
		} else if (!assetNumber.equals(other.assetNumber))
			return false;
		if (assetSubnum == null) {
			if (other.assetSubnum != null)
				return false;
		} else if (!assetSubnum.equals(other.assetSubnum))
			return false;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (cgstPer == null) {
			if (other.cgstPer != null)
				return false;
		} else if (!cgstPer.equals(other.cgstPer))
			return false;
		if (cgstVal == null) {
			if (other.cgstVal != null)
				return false;
		} else if (!cgstVal.equals(other.cgstVal))
			return false;
		if (companyCode == null) {
			if (other.companyCode != null)
				return false;
		} else if (!companyCode.equals(other.companyCode))
			return false;
		if (condDocnumber == null) {
			if (other.condDocnumber != null)
				return false;
		} else if (!condDocnumber.equals(other.condDocnumber))
			return false;
		if (controlCode == null) {
			if (other.controlCode != null)
				return false;
		} else if (!controlCode.equals(other.controlCode))
			return false;
		if (costCenter == null) {
			if (other.costCenter != null)
				return false;
		} else if (!costCenter.equals(other.costCenter))
			return false;
		if (costElement == null) {
			if (other.costElement != null)
				return false;
		} else if (!costElement.equals(other.costElement))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		if (custTaxStcd3 == null) {
			if (other.custTaxStcd3 != null)
				return false;
		} else if (!custTaxStcd3.equals(other.custTaxStcd3))
			return false;
		if (delIndicator != other.delIndicator)
			return false;
		if (exchangeRate == null) {
			if (other.exchangeRate != null)
				return false;
		} else if (!exchangeRate.equals(other.exchangeRate))
			return false;
		if (funcArea == null) {
			if (other.funcArea != null)
				return false;
		} else if (!funcArea.equals(other.funcArea))
			return false;
		if (igstPer == null) {
			if (other.igstPer != null)
				return false;
		} else if (!igstPer.equals(other.igstPer))
			return false;
		if (igstVal == null) {
			if (other.igstVal != null)
				return false;
		} else if (!igstVal.equals(other.igstVal))
			return false;
		if (incoterm1 == null) {
			if (other.incoterm1 != null)
				return false;
		} else if (!incoterm1.equals(other.incoterm1))
			return false;
		if (incoterm2 == null) {
			if (other.incoterm2 != null)
				return false;
		} else if (!incoterm2.equals(other.incoterm2))
			return false;
		if (itemCat == null) {
			if (other.itemCat != null)
				return false;
		} else if (!itemCat.equals(other.itemCat))
			return false;
		if (manufactNumber == null) {
			if (other.manufactNumber != null)
				return false;
		} else if (!manufactNumber.equals(other.manufactNumber))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (materialGroup == null) {
			if (other.materialGroup != null)
				return false;
		} else if (!materialGroup.equals(other.materialGroup))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (netPrice == null) {
			if (other.netPrice != null)
				return false;
		} else if (!netPrice.equals(other.netPrice))
			return false;
		if (netValue == null) {
			if (other.netValue != null)
				return false;
		} else if (!netValue.equals(other.netValue))
			return false;
		if (networkNumber == null) {
			if (other.networkNumber != null)
				return false;
		} else if (!networkNumber.equals(other.networkNumber))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (packLineno == null) {
			if (other.packLineno != null)
				return false;
		} else if (!packLineno.equals(other.packLineno))
			return false;
		if (packNo == null) {
			if (other.packNo != null)
				return false;
		} else if (!packNo.equals(other.packNo))
			return false;
		if (plant == null) {
			if (other.plant != null)
				return false;
		} else if (!plant.equals(other.plant))
			return false;
		if (poDate == null) {
			if (other.poDate != null)
				return false;
		} else if (!poDate.equals(other.poDate))
			return false;
		if (poItem == null) {
			if (other.poItem != null)
				return false;
		} else if (!poItem.equals(other.poItem))
			return false;
		if (poNumber == null) {
			if (other.poNumber != null)
				return false;
		} else if (!poNumber.equals(other.poNumber))
			return false;
		if (poType == null) {
			if (other.poType != null)
				return false;
		} else if (!poType.equals(other.poType))
			return false;
		if (prItem == null) {
			if (other.prItem != null)
				return false;
		} else if (!prItem.equals(other.prItem))
			return false;
		if (prNumber == null) {
			if (other.prNumber != null)
				return false;
		} else if (!prNumber.equals(other.prNumber))
			return false;
		if (profitCenter == null) {
			if (other.profitCenter != null)
				return false;
		} else if (!profitCenter.equals(other.profitCenter))
			return false;
		if (purchGroup == null) {
			if (other.purchGroup != null)
				return false;
		} else if (!purchGroup.equals(other.purchGroup))
			return false;
		if (purchOrg == null) {
			if (other.purchOrg != null)
				return false;
		} else if (!purchOrg.equals(other.purchOrg))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (releaseState == null) {
			if (other.releaseState != null)
				return false;
		} else if (!releaseState.equals(other.releaseState))
			return false;
		if (salesDoc == null) {
			if (other.salesDoc != null)
				return false;
		} else if (!salesDoc.equals(other.salesDoc))
			return false;
		if (salesItem == null) {
			if (other.salesItem != null)
				return false;
		} else if (!salesItem.equals(other.salesItem))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		if (sericeTaxtarrif == null) {
			if (other.sericeTaxtarrif != null)
				return false;
		} else if (!sericeTaxtarrif.equals(other.sericeTaxtarrif))
			return false;
		if (serviceMeins == null) {
			if (other.serviceMeins != null)
				return false;
		} else if (!serviceMeins.equals(other.serviceMeins))
			return false;
		if (serviceQty == null) {
			if (other.serviceQty != null)
				return false;
		} else if (!serviceQty.equals(other.serviceQty))
			return false;
		if (serviceTaxcd == null) {
			if (other.serviceTaxcd != null)
				return false;
		} else if (!serviceTaxcd.equals(other.serviceTaxcd))
			return false;
		if (serviceText == null) {
			if (other.serviceText != null)
				return false;
		} else if (!serviceText.equals(other.serviceText))
			return false;
		if (sgstPer == null) {
			if (other.sgstPer != null)
				return false;
		} else if (!sgstPer.equals(other.sgstPer))
			return false;
		if (sgstVal == null) {
			if (other.sgstVal != null)
				return false;
		} else if (!sgstVal.equals(other.sgstVal))
			return false;
		if (storageLoc == null) {
			if (other.storageLoc != null)
				return false;
		} else if (!storageLoc.equals(other.storageLoc))
			return false;
		if (taxCode == null) {
			if (other.taxCode != null)
				return false;
		} else if (!taxCode.equals(other.taxCode))
			return false;
		if (taxNumber == null) {
			if (other.taxNumber != null)
				return false;
		} else if (!taxNumber.equals(other.taxNumber))
			return false;
		if (textInfo == null) {
			if (other.textInfo != null)
				return false;
		} else if (!textInfo.equals(other.textInfo))
			return false;
		if (uom == null) {
			if (other.uom != null)
				return false;
		} else if (!uom.equals(other.uom))
			return false;
		if (valuationType == null) {
			if (other.valuationType != null)
				return false;
		} else if (!valuationType.equals(other.valuationType))
			return false;
		if (vendor == null) {
			if (other.vendor != null)
				return false;
		} else if (!vendor.equals(other.vendor))
			return false;
		if (wbs == null) {
			if (other.wbs != null)
				return false;
		} else if (!wbs.equals(other.wbs))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Result [assetSubnum=" + assetSubnum + ", funcArea=" + funcArea + ", igstPer=" + igstPer
				+ ", delIndicator=" + delIndicator + ", assetNumber=" + assetNumber + ", name=" + name + ", poItem="
				+ poItem + ", packLineno=" + packLineno + ", purchGroup=" + purchGroup + ", releaseState="
				+ releaseState + ", currency=" + currency + ", textInfo=" + textInfo + ", serviceText=" + serviceText
				+ ", manufactNumber=" + manufactNumber + ", order=" + order + ", poNumber=" + poNumber
				+ ", condDocnumber=" + condDocnumber + ", prNumber=" + prNumber + ", serviceTaxcd=" + serviceTaxcd
				+ ", custTaxStcd3=" + custTaxStcd3 + ", poDate=" + poDate + ", purchOrg=" + purchOrg + ", netPrice="
				+ netPrice + ", serialNumber=" + serialNumber + ", materialGroup=" + materialGroup + ", prItem="
				+ prItem + ", netValue=" + netValue + ", poType=" + poType + ", incoterm1=" + incoterm1
				+ ", storageLoc=" + storageLoc + ", incoterm2=" + incoterm2 + ", exchangeRate=" + exchangeRate
				+ ", message=" + message + ", networkNumber=" + networkNumber + ", plant=" + plant + ", packNo="
				+ packNo + ", costCenter=" + costCenter + ", taxCode=" + taxCode + ", batch=" + batch + ", costElement="
				+ costElement + ", taxNumber=" + taxNumber + ", __metadata=" + __metadata + ", sericeTaxtarrif="
				+ sericeTaxtarrif + ", valuationType=" + valuationType + ", salesDoc=" + salesDoc + ", serviceQty="
				+ serviceQty + ", profitCenter=" + profitCenter + ", wbs=" + wbs + ", quantity=" + quantity
				+ ", material=" + material + ", vendor=" + vendor + ", salesItem=" + salesItem + ", controlCode="
				+ controlCode + ", uom=" + uom + ", cgstVal=" + cgstVal + ", accAssignCat=" + accAssignCat
				+ ", igstVal=" + igstVal + ", cgstPer=" + cgstPer + ", itemCat=" + itemCat + ", sgstPer=" + sgstPer
				+ ", serviceMeins=" + serviceMeins + ", companyCode=" + companyCode + ", sgstVal=" + sgstVal + "]";
	}
    
}