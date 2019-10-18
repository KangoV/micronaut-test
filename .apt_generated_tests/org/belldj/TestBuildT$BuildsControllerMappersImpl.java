package org.belldj;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import org.belldj.BuildT.Builder;
import org.belldj.TestBuildT.BuildsControllerMappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-18T15:08:40+0100",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.19.0.v201910172144-e1909, environment: Java 11.0.4 (Ubuntu)"
)
public class TestBuildT$BuildsControllerMappersImpl implements BuildsControllerMappers {

    @Override
    public BuildT map(BuildD buildd) {
        if ( buildd == null ) {
            return null;
        }

        Builder buildT = BuildT.builder();

        buildT.dependencies( buildd.getDependencies() );
        buildT.id( (int) buildd.getId() );
        Map<LabelType, String> map = buildd.getLabels();
        if ( map != null ) {
            buildT.labels( new HashMap<LabelType, String>( map ) );
        }
        buildT.name( buildd.getName() );
        Map<String, String> map1 = buildd.getProperties();
        if ( map1 != null ) {
            buildT.properties( new HashMap<String, String>( map1 ) );
        }

        return buildT.build();
    }

    @Override
    public BuildD map(BuildT buildt) {
        if ( buildt == null ) {
            return null;
        }

        org.belldj.BuildD.Builder buildD = BuildD.builder();

        Set<String> set = buildt.getDependencies();
        if ( set != null ) {
            buildD.dependencies( new HashSet<String>( set ) );
        }
        buildD.id( buildt.getId() );
        Map<LabelType, String> map = buildt.getLabels();
        if ( map != null ) {
            buildD.labels( new HashMap<LabelType, String>( map ) );
        }
        buildD.name( buildt.getName() );
        Map<String, String> map1 = buildt.getProperties();
        if ( map1 != null ) {
            buildD.properties( new HashMap<String, String>( map1 ) );
        }

        return buildD.build();
    }
}
