package dev.mdrobot.booksapifeignclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VolumeInfo {

    private String title;
    private List<String> authors;
}
