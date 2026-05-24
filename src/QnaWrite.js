import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function QnaWrite() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    title: "",
    content: "",
    writer: ""
  });

  const onChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value
    });
  };

  const onSubmit = async () => {
    try {
      await axios.post("http://localhost:8080/api/qna", form);
      alert("등록 완료!");
      navigate("/qna");
    } catch (err) {
      console.log(err);
      alert("등록 실패");
    }
  };

  return (
    <div style={{ maxWidth: "800px", margin: "120px auto", padding: "20px" }}>
      <h2>QNA 글쓰기</h2>

      <input
        name="title"
        placeholder="제목"
        onChange={onChange}
        style={{ width: "100%", padding: "10px", marginTop: "10px" }}
      />

      <input
        name="writer"
        placeholder="작성자"
        onChange={onChange}
        style={{ width: "100%", padding: "10px", marginTop: "10px" }}
      />

      <textarea
        name="content"
        placeholder="내용"
        onChange={onChange}
        style={{ width: "100%", height: "200px", padding: "10px", marginTop: "10px" }}
      />

      <button
        onClick={onSubmit}
        style={{
          marginTop: "20px",
          padding: "12px 20px",
          background: "black",
          color: "white",
          border: "none",
          cursor: "pointer"
        }}
      >
        등록
      </button>
    </div>
  );
}