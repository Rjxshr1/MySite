package my.config;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import org.apache.commons.io.FilenameUtils;

/**
 * Created by Administrator on 2017/4/13 0013.
 */
public class ModelGenerator {
    //生成模型代码
    public static void generateModels() {
        // 读取配置文件
        Prop prop = PropKit.use("myconfig.properties");
        //配置生成的源文件位置，getWebRootPath()为web所在目录,..为上一级目录，应该生成在src目录中
        String basePath = FilenameUtils.concat(PathKit.getWebRootPath(), "../src");
        //模型基类包名
        String baseModelPackageName = "my.model.base";
        //模型类包名
        String modelPackageName = "my.model";
        //模型基类生成的位置，要放在相应的包中
        String baseModelPath = FilenameUtils.concat(basePath, "my/model/base");
        //模型类生成的位置
        String modelPath = FilenameUtils.concat(basePath, "my/model");
        Generator generator = new Generator(MainConfig.getDataSource(), baseModelPackageName, baseModelPath, modelPackageName, modelPath);
        //SQL方言为MYSQL
        generator.setDialect(new MysqlDialect());
        //是否在model中生成dao字段
        generator.setGenerateDaoInModel(true);
        generator.setMappingKitOutputDir(modelPath);
        generator.setMappingKitPackageName(modelPackageName);
        generator.generate();
    }

    public static void main(String[] args) {
        generateModels();
    }
}
