package com.example.librarymanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.librarymanagement.BookAdapter.Book;
import com.example.librarymanagement.BookAdapter.BookAdapter;

import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private EditText searchEditText;
    private List<Book> books;  // Danh sách chứa tất cả sách

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        searchEditText = findViewById(R.id.search_edit_text);

        // Khởi tạo dữ liệu sách (thay thế bằng nguồn dữ liệu của bạn)
        books = createBookList();

        // Cài đặt adapter cho ListView
        BookAdapter adapter = new BookAdapter(this, books);
        listView.setAdapter(adapter);

        // Thực hiện chức năng tìm kiếm với listener
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
            // ... xử lý thay đổi văn bản và lọc sách dựa trên nội dung nhập
            // cập nhật adapter với dữ liệu đã lọc
        });

        // Thực hiện click listener cho các mục ListView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Book selectedBook = books.get(position);

                // Bắt đầu activity mới để hiển thị chi tiết sách
                Intent intent = new Intent(ListViewActivity.this, XemThongTinSachActivity.class);
                intent.putExtra("book", (CharSequence) selectedBook);
                startActivity(intent);
            }
        });
    }

    // Phương thức để tạo danh sách Book ban đầu của bạn
    private List<Book> createBookList() {
        List<Book> bookList = new ArrayList();
        // ... Thêm các đối tượng Book với chi tiết
        return bookList;
    }
}