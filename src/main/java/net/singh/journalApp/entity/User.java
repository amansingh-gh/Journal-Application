package net.singh.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String username;

    @NonNull
    private String password;
    // DBRef for reference of journal entries
    @DBRef
    private List<JournalEntry> journalEntries = new ArrayList<>();
    //    private List<String> roles;        -> deepseek
    private List<String> roles = new ArrayList<>();
}