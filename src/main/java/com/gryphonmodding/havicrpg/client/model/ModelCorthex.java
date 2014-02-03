package com.gryphonmodding.havicrpg.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCorthex extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Tail;
    ModelRenderer leg1Plate;
    ModelRenderer leg2Plate;
    ModelRenderer leg3Plate;
    ModelRenderer leg4Plate;
  
  public ModelCorthex()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -4F, -8F, 6, 8, 6);
      head.setRotationPoint(1F, 10F, -5F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 32, 8);
      body.addBox(-5F, -10F, -7F, 10, 16, 6);
      body.setRotationPoint(0F, 9F, 3F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 16);
      leg1.addBox(-2F, 0F, -2F, 4, 8, 4);
      leg1.setRotationPoint(-7F, 16F, 7F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 16);
      leg2.addBox(-2F, 0F, -2F, 4, 8, 4);
      leg2.setRotationPoint(7F, 16F, 7F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 16);
      leg3.addBox(-2F, 18F, -2F, 4, 8, 4);
      leg3.setRotationPoint(-7F, -2F, -5F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 16);
      leg4.addBox(-2F, 0F, -2F, 4, 8, 4);
      leg4.setRotationPoint(7F, 16F, -5F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 25, 0);
      Tail.addBox(0F, 0F, 0F, 2, 8, 2);
      Tail.setRotationPoint(0F, 13F, 8F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 1.226894F, 0F, 0F);
      leg1Plate = new ModelRenderer(this, 17, 22);
      leg1Plate.addBox(0F, 0F, 0F, 3, 1, 4);
      leg1Plate.setRotationPoint(-8F, 15F, 5F);
      leg1Plate.setTextureSize(64, 32);
      leg1Plate.mirror = true;
      setRotation(leg1Plate, 0F, 0F, 0F);
      leg2Plate = new ModelRenderer(this, 16, 22);
      leg2Plate.addBox(0F, 0F, 0F, 3, 1, 4);
      leg2Plate.setRotationPoint(5F, 15F, 5F);
      leg2Plate.setTextureSize(64, 32);
      leg2Plate.mirror = true;
      setRotation(leg2Plate, 0F, 0F, 0F);
      leg3Plate = new ModelRenderer(this, 17, 22);
      leg3Plate.addBox(0F, 0F, 0F, 3, 1, 4);
      leg3Plate.setRotationPoint(-8F, 15F, -7F);
      leg3Plate.setTextureSize(64, 32);
      leg3Plate.mirror = true;
      setRotation(leg3Plate, 0F, 0F, 0F);
      leg4Plate = new ModelRenderer(this, 17, 22);
      leg4Plate.addBox(0F, 0F, 0F, 3, 1, 4);
      leg4Plate.setRotationPoint(5F, 15F, -7F);
      leg4Plate.setTextureSize(64, 32);
      leg4Plate.mirror = true;
      setRotation(leg4Plate, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    Tail.render(f5);
    leg1Plate.render(f5);
    leg2Plate.render(f5);
    leg3Plate.render(f5);
    leg4Plate.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}