package de.upb.wdqa.wdvd.features.item.misc;

import java.util.Iterator;

import org.wikidata.wdtk.datamodel.interfaces.ItemDocument;
import org.wikidata.wdtk.datamodel.interfaces.Statement;

import de.upb.wdqa.wdvd.Revision;
import de.upb.wdqa.wdvd.features.FeatureImpl;
import de.upb.wdqa.wdvd.features.FeatureIntegerValue;

public class NumberOfStatements extends FeatureImpl {
	
	@Override
	public FeatureIntegerValue calculate(Revision revision) {
		int result = 0;
		ItemDocument itemDocument = revision.getItemDocument();
		
		if(itemDocument != null){		
			Iterator<Statement> statements = itemDocument.getAllStatements();
			
			while(statements.hasNext()){
				statements.next();	
				result += 1;			
			}
		}

		return new FeatureIntegerValue(result);
	}

}