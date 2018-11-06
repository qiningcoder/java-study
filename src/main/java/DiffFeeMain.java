import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DiffFeeMain {
    public static void main(String[] args) throws IOException {
        String pathDirErr = "/Users/shiqining/feedd/fee/";
        String pathDirRig = "/Users/shiqining/fee/";

        String diffResultPath = "/Users/shiqining/diff/";
        Set<String> errCompCodes = Sets.newHashSet("ZZKZ0001", "ZZFKD200001", "ZZDY0001", "ZXWY200001",
                "ZLZZ8888", "ZJWJ0001", "ZJKDY100001", "ZJGZ8888", "ZJDY0001", "ZJDY00001");

        File errDir = new File(pathDirErr);
        String[] errFiles = errDir.list();
        List<String> errFilenames = Arrays.stream(errFiles).filter(e -> {
            for (String compCode : errCompCodes) {
                if (e.contains(compCode)) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList());

        for (String errFilename : errFilenames) {
            String path1 = pathDirRig + errFilename;
            String path2 = pathDirErr + errFilename;
            List<String> c1 = readFeeContent(path1);
            List<String> c2 = readFeeContent(path2);
            List<String> diff = diff(c1, c2);

            String diffPath = diffResultPath + errFilename;
            write(diffPath, diff);
        }

    }

    public static void write(String filePath, List<String> content) {
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 在对应的Excel中建立一个分表

        XSSFSheet sheet = workBook.createSheet();

        for (int i = 0; i < content.size(); i++) {
            String line = content.get(i);
            List<String> elements = Splitter.on("\t").splitToList(line);
            XSSFRow row = sheet.createRow(i);
            for (int j = 0; j < elements.size(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(elements.get(j));
            }
        }

        try {
            workBook.write( new FileOutputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static List<String> diff(List<String> content1, List<String> content2) {
        Set<String> c1 = Sets.newHashSet(content1);
        Set<String> c2 = Sets.newHashSet(content2);

        Set<String> diff = Sets.difference(c1, c2);
        return Lists.newArrayList(diff);
    }

    public static List<String> readFeeContent(String filePath) throws IOException {
        List<String> result = Lists.newArrayList();
        XSSFWorkbook workBook = new XSSFWorkbook(filePath);
        XSSFSheet sheet = workBook.getSheetAt(0);
        List<Row> rows = Lists.newArrayList(sheet.rowIterator());
        for (Row row : rows) {
            List<Cell> cells = Lists.newArrayList(row.cellIterator());
            List<String> elems = Lists.newArrayList();
            for (Cell cell : cells) {
                elems.add(cell.getStringCellValue());
            }
            String line = Joiner.on("\t").join(elems);
            result.add(line);
        }
        return result;
    }
}
