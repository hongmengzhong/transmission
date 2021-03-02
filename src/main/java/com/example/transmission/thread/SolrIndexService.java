package com.example.transmission.thread;

import com.example.transmission.msdata.product.entity.Product;
import com.example.transmission.msdata.product.mapper.MsProductMapper;
import com.example.transmission.util.SolrJUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.List;


/**
 * @author chao.z
 */
@Slf4j
public class SolrIndexService extends Thread{


    public static MsProductMapper productSolrDao= SpringContextHolder.getBean(MsProductMapper.class);



    private List<String> idsList;



    public SolrIndexService(List<String> idsList){
        this.idsList = idsList;
    }


    @Override
    public void run(){
        super.run();
        try {
            log.warn("=====进入solr导入");
            List<Product> productSolrDataList = productSolrDao.productSolrdataList(idsList);
            Integer index = 0;
            HttpSolrServer client = SolrJUtils.getClient();
            for(Product product:productSolrDataList){
            ++index;
                SolrInputDocument doc=new SolrInputDocument();
                //solr域中插入值,域要先定义后使用
                String ktyoeid = product.getKtypeid()==null?"":product.getKtypeid();
                String productImei = product.getProductImei()==null?"":product.getProductImei();
                doc.addField("id", product.getId()+ktyoeid+productImei);
                doc.addField("productId",product.getId());
                doc.addField("imeiManage",product.getImeiManage());
                doc.addField("commodityInitials",product.getCommodityInitials());
                doc.addField("rfid",product.getRfid() == null?"":product.getRfid());
                doc.addField("name",product.getName()==null?"":product.getName());
                doc.addField("companyCode",product.getCompanycode()==null?"":product.getCompanycode());
                doc.addField("mnemonicCode",product.getMnemonicCode()==null?"":product.getMnemonicCode());
                doc.addField("productCategoryId",product.getProductCategory() ==null ?"":product.getProductCategory().getId());
                doc.addField("ktypeId",product.getKtypeid()==null?"":product.getKtypeid());
                doc.addField("productImei",product.getProductImei()==null?"":product.getProductImei());
                doc.addField("barCode",product.getBarCode()==null?"":product.getBarCode());
                doc.addField("retailPrice",product.getRetailPrice()==null?0:product.getRetailPrice());
                doc.addField("memberPrice",product.getMemberPrice()==null?0:product.getMemberPrice());
                doc.addField("priceType",product.getPriceType()==null?"":product.getPriceType());
                doc.addField("batchManage",product.getBatchManage()==null?"":product.getBatchManage());
                doc.addField("unitType",product.getUnitType()==null?"":product.getUnitType());
                doc.addField("serialzNumber",product.getSerialzNumber()==null?"":product.getSerialzNumber());
                doc.addField("productUnitId",product.getProductUnit()==null?"":product.getProductUnit().getId());
                doc.addField("productMultipleUnitId",product.getProductMultipleUnit()==null ?"":product.getProductMultipleUnit().getId());
                doc.addField("productSubUnitId",product.getProductSubUnit() == null ?"":product.getProductSubUnit().getId());
                doc.addField("productSubUnitName",product.getProductSubUnit() == null ?"":product.getProductSubUnit().getName());
                doc.addField("productSubUnitCount",product.getProductSubUnit() == null ?"":product.getProductSubUnit().getCount());
                doc.addField("productSubUnitMainUnitFlag",product.getProductSubUnit() == null ?"":product.getProductSubUnit().getMainUnitFlag());
                doc.addField("productUnitPrice",product.getProductUnitPrice() == null ?"":product.getProductUnitPrice().getPrice());
                doc.addField("productPhotoList",product.getProductPhotoList() == null ?"":product.getProductPhotoList().toString());
                doc.addField("productUnitName",product.getProductUnit()== null ?"":product.getProductUnit().getName());
                doc.addField("productPhoto",product.getProductPhotoList() == null?"":product.getProductPhotoList().toString());
                doc.addField("kcnum",product.getKcnum() == null?"":product.getKcnum().toString());
                doc.addField("imeiSelectFlag",product.getImeiSelectFlag() == null ?"":product.getImeiSelectFlag());
                doc.addField("heDeFlag",product.getHeDeFlag());
                client.add(doc);
            if (index % 1000 == 0){
                System.out.println("starting.....");
                client.commit();
                doc.clear();
            }
        }
            System.out.println("ending.....");
        } catch (SolrServerException e) {
            log.warn("=====抛出SolrServerException");
            e.printStackTrace();
        } catch (IOException e) {
            log.warn("=====IOException");
            e.printStackTrace();
        }finally {
            try {
                System.out.println("finally....");
                SolrJUtils.getClient().commit();
            } catch (SolrServerException e) {
                log.warn("=====抛出SolrServerException1");
                e.printStackTrace();
            } catch (IOException e) {
                log.warn("=====IOException1");
                e.printStackTrace();
            }
        }

    }
}
