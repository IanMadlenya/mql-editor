package org.pentaho.commons.metadata.mqleditor.editor.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.pentaho.commons.metadata.mqleditor.MqlDomain;
import org.pentaho.commons.metadata.mqleditor.MqlQuery;
import org.pentaho.commons.metadata.mqleditor.editor.service.CWMStartup;
import org.pentaho.commons.metadata.mqleditor.editor.service.MQLEditorService;
import org.pentaho.pms.core.CWM;
import org.pentaho.pms.factory.CwmSchemaFactory;
import org.pentaho.ui.xul.XulServiceCallback;

public class MQLEditorServiceDebugImpl implements MQLEditorService{

  MQLEditorServiceDeligate deligate;

  public MQLEditorServiceDebugImpl(){

    CWMStartup.loadCWMInstance("/org/pentaho/commons/metadata/mqleditor/sampleMql/metadata/repository.properties", "/org/pentaho/commons/metadata/mqleditor/sampleMql/metadata/PentahoCWM.xml"); //$NON-NLS-1$ //$NON-NLS-2$
    CWM cwm = CWMStartup.loadMetadata("/org/pentaho/commons/metadata/mqleditor/sampleMql/metadata_steelwheels.xmi", "/org/pentaho/commons/metadata/mqleditor/sampleMql"); //$NON-NLS-1$ //$NON-NLS-2$

    CwmSchemaFactory factory = new CwmSchemaFactory();
    
    List<CWM> cwms = new ArrayList<CWM>();
    cwms.add(cwm);
    
    deligate = new MQLEditorServiceDeligate(cwms, factory);
  }

  public void getDomainByName(String name, XulServiceCallback<MqlDomain> callback) {
    callback.success(deligate.getDomainByName(name));
  }

  public void getMetadataDomains(XulServiceCallback<List<MqlDomain>> callback) {
    callback.success(deligate.getMetadataDomains());
  }

  public void saveQuery(MqlQuery model, XulServiceCallback<String> callback) {
    callback.success(deligate.saveQuery(model));
  }

  public void serializeModel(MqlQuery query, XulServiceCallback<String> callback) {
    callback.success(deligate.serializeModel(query));
  }

  public void getPreviewData(String query, int page, int limit, XulServiceCallback<String[][]> callback) {
    callback.error("Operation not supported", new NotImplementedException("Implement in a subclass of this service"));
  }

  public void deserializeModel(String serializedQuery, XulServiceCallback<MqlQuery> callback) {
    callback.success(deligate.deserializeModel(serializedQuery));
  }
  
  
  
}

  