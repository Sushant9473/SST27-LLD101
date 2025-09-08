package com.example.imports;

import java.nio.file.Path;
import java.util.List;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = csvReader;
        this.profileService = profileService;
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int importedCount = 0;

        for (String[] row : rows) {
            if (row.length < 3) {
                System.out.println("Skipped invalid row: " + String.join(",", row) + " - missing required fields");
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row[2].trim();

            try {
                if (id.isEmpty() || email.isEmpty()) {
                    System.out.println("Skipped invalid row: " + String.join(",", row) + " - missing required fields");
                    continue;
                }

                profileService.createProfile(id, email, displayName);
                importedCount++;
            } catch (Exception e) {
                System.out.println("Skipped invalid row: " + String.join(",", row) + " - " + e.getMessage());
            }
        }

        return importedCount;
    }
}
